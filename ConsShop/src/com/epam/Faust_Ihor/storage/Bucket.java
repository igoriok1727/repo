package com.epam.Faust_Ihor.storage;

import java.util.HashMap;
import java.util.Map;

import com.epam.Faust_Ihor.entity.WritingGood;

public class Bucket {

	private Map<Long, Integer> map = new HashMap<Long, Integer>();

	public void addToBucket(WritingGood wg) {
		if (map.containsKey(wg.code())) {
			map.put(wg.code(), map.get(wg.code()) + 1);
		} else {
			map.put(wg.code(), 1);
		}
	}

	public Map<Long, Integer> getMap() {
		return map;
	}
	
	public void clear() {
	    map.clear();
	}

}
