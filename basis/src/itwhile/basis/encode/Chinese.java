package itwhile.basis.encode;

public class Chinese
{

	/**
	 * 判断是否包含中文，但不能判断是否是中文标点
	 * 
	 * @param str
	 * @return
	 */
	public static boolean existChinese(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c >= 0x4e00) && (c <= 0x9fbb)) {
				return true;
			}
		}
		return false;
	}

}
