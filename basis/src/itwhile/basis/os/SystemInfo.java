package itwhile.basis.os;

/**
 * System information
 * 
 * @author bridge
 * 
 */
public class SystemInfo
{
	private String name;
	private String version;
	
	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}
	
	private SystemInfo(){
		this.name = System.getProperty("os.name");
		this.version = System.getProperty("os.version");
	}
	
	private static SystemInfo instance;
	
	public static SystemInfo getInstance(){
		if (instance == null) 
			instance = new SystemInfo();
		return instance;
	}
	
}
