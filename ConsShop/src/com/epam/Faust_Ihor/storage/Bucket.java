package com.epam.Faust_Ihor.storage;

import java.util.LinkedHashMap;

import com.epam.Faust_Ihor.entity.WritingGood;

public class Bucket {

	private LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();

	public void addToBucket(WritingGood wg) {
		if (map.containsKey(wg)) {
			map.put(wg.code(), map.get(wg.code()) + 1);
		} else {
			map.put(wg.code(), 1);
		}
	}

	public LinkedHashMap<Long, Integer> getMap() {
		return map;
	}

}
