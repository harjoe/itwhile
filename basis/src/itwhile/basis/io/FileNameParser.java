package itwhile.basis.io;

import java.io.File;
import java.util.Arrays;

/**
 * 文件工具类
 * 
 * @author bridge
 * 
 */
public class FileNameParser
{

	private FileNameParser()
	{
	}

	/**
	 * 获取文件名后缀(不含".")
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExt(String filename)
	{
		int point = filename.lastIndexOf(".");
		return filename.substring(point + 1);
	}

	/**
	 * 获取文件名(不包含后缀)
	 * 
	 * @param filename
	 * @return
	 */
	public static String getName(String filename)
	{
		filename = getFull(filename);
		int point = filename.lastIndexOf(".");
		return filename.substring(0, point);
	}

	/**
	 * 获取文件名(包含后缀)
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFull(String filename)
	{
		int slash = filename.lastIndexOf("/");
		return filename.substring(slash + 1);
	}

	/**
	 * 判断指定格式是否为图片
	 * 
	 * @param ext
	 * @return
	 */
	public static boolean isImageExt(String ext)
	{
		return ext != null
				&& Arrays.asList("jpg", "jpeg", "png", "bmp", "gif").contains(ext.toLowerCase());
	}

	/**
	 * 生成文件存储名
	 * 
	 * @param parent
	 * @param fileName
	 * @return
	 * @deprecated
	 */
	public static File determineFile(File parent, String fileName)
	{
		String name = getName(fileName);
		String ext = getExt(fileName);
		File temp = new File(parent, fileName);
		for (int i = 1; temp.exists(); i++)
		{
			temp = new File(parent, name + i + "." + ext);
		}

		return temp;
	}

}
