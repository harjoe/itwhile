/*
 * @version Revision: 1.1, Date: 2016-1-12, Author: bridge <br>
 * 		   
 * */
package itwhile.application.validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  validate 
 * 
 * */
public class SimpleEntityValidator<T> implements EntityValidator<T> {

	@Override
	public Map<?, ?> insert(T instance) {
		return new HashMap<>();
	}

	public Map<?, ?> merge(T instance) {
		return new HashMap<>();
	}

	public Map<?, ?> update(T instance) {
		return new HashMap<>();
	}

	public Map<?, ?> delete(T instance) {
		return new HashMap<>();
	}

	public Map<?, ?> insertBatch(List<T> instances) {
		return new HashMap<>();
	}

	public Map<?, ?> mergeBatch(List<T> instances) {
		return new HashMap<>();
	}

	public Map<?, ?> updateBatch(List<T> instances) {
		return new HashMap<>();
	}

	public Map<?, ?> deleteBatch(List<T> instance) {
		return new HashMap<>();
	}

}
