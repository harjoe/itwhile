package itwhile.basis.paging;

import java.util.Map;

import itwhile.basis.paging.Page;

/**
 * 
 * @author bridge
 */
public interface PageSupport
{

	public Page getPage();

	public void setPage(Page page);

	public Map<String, Object> getCondition();
	
	public void setCondition(Map<String, Object> condition);
	
	
	/**
	 * 当 size = 0 分页无效
	 * */
	public boolean isEffect();

	/**
	 * 生成查询数量sql
	 */
	public String countSql(String sql);

	/**
	 * 生成分页sql
	 */
	public String pageSql(String sql);

}
