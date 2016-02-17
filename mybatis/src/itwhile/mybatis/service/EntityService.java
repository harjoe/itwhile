package itwhile.mybatis.service;

import java.util.List;
import itwhile.basis.paging.PageSupport;
import itwhile.mybatis.mapper.EntityMapper;

public abstract class EntityService
{

	public abstract EntityMapper getMapper();
	
	public <T> int insert(T instance) {
		return getMapper().insert(instance);
	}

	public <T> int update(T instance) {
		return getMapper().update(instance);
	}

	public int deleteById(String id) {
		return getMapper().deleteById(id);
	}

	public <T> T loadById(String id) {
		return getMapper().loadById(id);
	}

	public <T> List<T> list() {
		return getMapper().list();
	}

	public <T> List<T> list(PageSupport support) {
		return getMapper().list(support);
	}

	public long count() {
		return getMapper().count();
	}

}