/*
 * @author	bridge
 * @create	2013-5-27
 * @version Revision: x.x, Date: 2015-1-8, Author: bridge <br>
 * @version Revision: 1.1.1, Date: 2016-1-14, Author: bridge <br>
 * 
 */

package itwhile.basis.util;

/**
 *  
 */
public class StringLinker
{
	private String value;
	
	public StringLinker(String source)
	{
		this.value = source;
	}

	public String getString()
	{
		return this.value;
	}
	
	/**
	 * 追加换行符
	 * */
	public StringLinker appendLineMark()
	{
		this.value += "\r\n";
		return this;
	}

	/**
	 * 拼接字符串
	 * */
	public StringLinker append(String value)
	{
		this.value += value;
		return this;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
}
