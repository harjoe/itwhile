package itwhile.basis.util;

import java.io.Closeable;
import java.io.IOException;

public final class Closer
{

	public static void close(Closeable... resources) throws IOException {
		for (int i = 0; i < resources.length; i++) {
			resources[i].close();
		}
	}

	/**
	 * close order by index.
	 * */
	public static void close(AutoCloseable... resources) throws Exception {
		for (int i = 0; i < resources.length; i++) {
			resources[i].close();
		}
	}

	/**
	 * reflect, Object.close()
	 * */
	public static void close(Object... objects) throws Exception {
		// TODO
		throw new Exception("TODO");
		
	}

}