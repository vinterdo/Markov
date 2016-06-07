package com.vinterdo.markov;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util
{
	public static <K, V> Map<K, V> create(Collection<K> keys, V value)
	{
		Map<K, V> map = new LinkedHashMap<K, V>();
		
		for (K k : keys)
		{
			map.put(k, value);
		}
		
		return map;
	}
}