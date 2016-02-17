package itwhile.mybatis.intercept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itwhile.basis.paging.PageSupport;
import itwhile.basis.reflect.FieldReflector;

/**
 *  Mybatis的分页查询插件，通过拦截StatementHandler的prepare方法来实现�?
 * 只有在参数列表中包括PageModel类型的参数时才进行分页查询�? 在多参数的情况下，只对第�?��PageModel类型的参数生效�?
 * 
 * @author zhou
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor
{
	static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		BaseStatementHandler delegate = (BaseStatementHandler) FieldReflector.getFieldValue(
				handler, "delegate");
		BoundSql boundSql = delegate.getBoundSql();

		// 获取分页参数
		Object param = boundSql.getParameterObject();
		if (param == null || !(param instanceof PageSupport))
			return invocation.proceed();

		PageSupport pageSupport = (PageSupport) param;
		if (!pageSupport.isEffect()) {
			return invocation.proceed();
		}

		String sql = boundSql.getSql();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection connection = (Connection) invocation.getArgs()[0];
			// 查询总记录数
			String countSql = pageSupport.countSql(sql);
			ps = connection.prepareStatement(countSql);
			FieldReflector.setFieldValue(boundSql, "sql", countSql);
			MappedStatement ms = (MappedStatement) FieldReflector.getFieldValue(delegate,
					"mappedStatement");
			DefaultParameterHandler dph = new DefaultParameterHandler(ms, param, boundSql);
			dph.setParameters(ps);

			rs = ps.executeQuery();
			Long count = (long) 0;
			if (rs.next()) {
				count = (Long) rs.getObject(1);
			}

			pageSupport.getPage().setCount(count);
		} catch (SQLException ex) {
			logger.error("can't get count " + ex.getMessage());
		} finally {
			rs.close();
			ps.close();
		}

		FieldReflector.setFieldValue(boundSql, "sql", pageSupport.pageSql(sql));

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		/* 当目标类是StatementHandler类型时，才包装目标类，不做无谓的代理 */
		return (target instanceof StatementHandler) ? Plugin.wrap(target, this) : target;
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
