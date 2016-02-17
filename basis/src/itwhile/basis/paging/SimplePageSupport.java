package itwhile.basis.paging;

import java.util.HashMap;
import java.util.Map;

import itwhile.basis.paging.Page;

/**
 * 
 * @author bridge
 */
public class SimplePageSupport implements PageSupport
{

	/**
	 * 当pageSize小于0时,为查询所有
	 * */
	private Page page = new Page();
	private Map<String, Object> condition = new HashMap<String, Object>();
	
	@Override
	public Page getPage() {
		return page;
	}  

	@Override
	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public Map<String, Object> getCondition() {
		
		return condition;
	}

	@Override
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
	
	public SimplePageSupport(Page page) {
		this.page = page;
	}

	@Override
	public boolean isEffect() {
		return (this.page != null) && (this.page.getSize() > 0);
	}

	/**
	 * 生成查询数量sql
	 * 
	 * @return
	 */
	@Override
	public String countSql(String sql) {
		return String.format("select count(*) from (%s) _temp_", sql);
	}

	/**
	 * 生成分页sql
	 * 
	 * @return
	 */
	@Override
	public String pageSql(String sql) {
		return String.format("%s limit %d,%d", sql, this.page.getStart(), this.page.getSize());
	}

}
