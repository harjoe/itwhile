package itwhile.basis.collection;

import java.util.Map;
import java.util.Objects;

public class MapExpand
{

	public static <K, V> K getKey(Map<K, V> map, V value)
	{
		K result = null;
		for (Map.Entry<K, V> entry : map.entrySet())
		{
			if (Objects.equals(entry.getValue(), value))
			{
				result = entry.getKey();
				break;
			}
		}

		return result;
	}

}
