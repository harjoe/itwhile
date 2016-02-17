/*
 * @author	bridge
 * @create	2013-5-4
 * @version Revision: x.x, Date: 2015-1-8, Author: bridge 
 * @version Revision: 1.1.1, Date: 2016-1-14, Author: bridge 		
 */

package itwhile.basis.util;

import java.util.List;

/**
 * 
 */
public class StringExpand
{
	/**
	 * if String.equals(""), return false;
	 * */
	public static boolean isEmpty(String data)
	{
		return data == null || data.equals("");
	}

	public static boolean isEmpty(String[] datas)
	{
		for (String data : datas)
			if (StringExpand.isEmpty(data))
				return true;
		return false;
	}

	public static boolean isEmpty(List<String> datas)
	{
		for (String data : datas)
			if (StringExpand.isEmpty(data))
				return true;
		return false;
	}

	/**
	 * 防止待处理的字符对象有可能为空 如果参数为空，则赋值为 ""
	 * 
	 * @return if parameter is null return true;
	 * */
	public static void preventNull(String object)
	{
		if (object == null)
			object = "";
	}
}
