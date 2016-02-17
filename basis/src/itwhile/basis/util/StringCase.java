/*
 * @(#)StringCase.java		1.1.0	2012-08-28
 * 
 * Author bridge
 * CopyRight 2012 snowpack, All rights reserved.
 */

package itwhile.basis.util;


/**
 * @version Revision: 1.2, Date: 2013-5-4, Author: bridge; <br />
 * */
public class StringCase
{
	
	public static boolean isLower(char c)
	{
		return c >= 'a' && c <= 'z';
	}
	
	public static boolean isUpper(char c)
	{
		return c >= 'A' && c <= 'Z';
	}
	
	public static char toUpper(char c)
	{
		if (isLower(c))
			return (char)(c - 32);
		return c;
	}
	
	public static char toLower(char c)
	{
		if (isUpper(c))
			return (char)(c + 32);
		return c;
	}
	
	/**
	 * @param source	
	 * @param index		the first index is 0;
	 * @return String
	 * @error Throws a exception when index < 0 || index >= source.length
	 * */
	public static String toUpper(String source, int index)
	{
		char[] cs = source.toCharArray();
		cs[index] = toUpper(cs[index]);
		return String.valueOf(cs);
	}
	
	/**
	 * @param source 
	 * @param start		the first is 0;
	 * @param len		
	 * @return String
	 * @error Throws exception
	 * */
	public static String toUpper(String source, int start, int len)
	{
		char[] cs = source.toCharArray();
		for (int i=start; i<start+len; i++)
			cs[i] = toUpper(cs[i]); 
		return String.valueOf(cs);
	}
	
	/**
	 * @error throws exception
	 * */
	public static String toLower(String source, int index)
	{
		char[] cs = source.toCharArray();
		cs[index] = toLower(cs[index]);
		return String.valueOf(cs);
	}
	
	/**
	 * @error need to throws exception
	 * */
	public static String toLower(String source, int start, int len)
	{
		char[] cs = source.toCharArray();
		for (int i =start; i<start+len; i++)
			cs[i] = toLower(cs[i]);
		return String.valueOf(cs);
	}

	
}
