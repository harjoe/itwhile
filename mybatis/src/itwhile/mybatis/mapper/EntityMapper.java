package itwhile.mybatis.mapper;

import itwhile.basis.paging.PageSupport;
import java.util.List;

public interface EntityMapper
{

	/**
	 * 新增记录
	 * @param t
	 */
	public <T> int insert(T instance);

	/**
	 * 更新记录
	 * @param t
	 */
	public <T> int update(T instance);

	
	public <T> int delete(T instance);
	
	/**
	 * 根据ID删除记录
 * 
	 * @param id
	 */
	public int deleteById(String id);

	
	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public <T> T loadById(String id);

	public <T> List<T> list(PageSupport support);

	public <T> List<T> list();

	/**
	 * 获取记录总数
	 */
	public long count();

}
