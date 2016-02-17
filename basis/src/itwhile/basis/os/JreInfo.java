package itwhile.basis.os;

/**
 * Jre info
 * 
 * @author bridge
 */
public class JreInfo
{
	private String version;
	/**
	 * MB
	 * */
	private long memory;

	public String getVersion() {
		return version;
	}

	public long getMemory() {
		return memory;
	}

	private void setMemory() {
		this.memory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
	}

	private JreInfo() {
		this.version = System.getProperty("java.version");
		this.setMemory();
	}

	private static JreInfo instance;

	public static JreInfo getInstance() {
		if (instance == null)
			instance = new JreInfo();
		else
			instance.setMemory();
		return instance;
	}

}
