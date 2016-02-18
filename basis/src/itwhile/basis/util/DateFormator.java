package itwhile.basis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormator
{
	public static final String PATTERN_DEFAULT = "HHMMDDSS";

	/**
	 * format now;
	 * */
	public static String format()
	{
		return format(PATTERN_DEFAULT, new Date());
	}

	public static String format(String pattern)
	{
		return format(pattern, new Date());
	}

	public static String format(Date date)
	{
		return format(PATTERN_DEFAULT, date);
	}

	public static String format(String pattern, Date date)
	{
		return format(pattern, date, Locale.getDefault(Locale.Category.FORMAT));
	}

	public static String format(String pattern, Date date, Locale locale)
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
		return format.format(date);
	}

	public static Date parse(String date) throws ParseException
	{
		return parse(PATTERN_DEFAULT, date);
	}

	/**
	 * 解析日期，注:此处为严格模式解析，�?0151809这样的日期会解析错误
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String pattern, String date) throws ParseException
	{
		return parse(pattern, date, Locale.getDefault(Locale.Category.FORMAT));
	}

	
	/**
	* 解析日期，注:此处为严格模式解析，�?0151809这样的日期会解析错误
	 * @param pattern
	 * @param date
	 * @param locale
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String pattern, String date, Locale locale) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
		format.setLenient(false);
		return format.parse(date);
	}

}
