/*
 * CopyRight itwhile.com
 * 
 * 	....		create
 * 	2013.01.26	
 * 			Type of the return was changed; The new type of the return is "Result";
 * 		Please see class "snow.hibernate.check.Result";
 * @version Revision: x.x, Date: 2015-1-10, Author: bridge <br>
 * @version Revision: 1.1, Date: 2016-1-12, Author: bridge <br>  
 * */

package itwhile.application.validate;

import java.util.List;
import java.util.Map;

/**
 *   
 */

public interface EntityValidator<T> extends Validator {

	public Map<?, ?> insert(T instance);

	public Map<?, ?> merge(T instance);

	public Map<?, ?> update(T instance);

	public Map<?, ?> delete(T instance);

	public Map<?, ?> insertBatch(List<T> instances);

	public Map<?, ?> mergeBatch(List<T> instances);

	public Map<?, ?> updateBatch(List<T> instances);

	public Map<?, ?> deleteBatch(List<T> instances);
}
