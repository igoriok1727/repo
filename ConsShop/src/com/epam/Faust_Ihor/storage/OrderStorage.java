package com.epam.Faust_Ihor.storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.epam.Faust_Ihor.entity.Order;

public class OrderStorage {

    private TreeMap<Date, Order> map = new TreeMap<Date, Order>();

    public void add(Date date, Order order) {
	map.put(date, order);
    }

    public List<Order> findOrdersBetween(Date least, Date highest) {
	return new ArrayList<Order>(map.subMap(least, true, highest, true)
		.values());
    }

    public Order nearestTo(Date date) {
	Entry<Date, Order> entry = map.ceilingEntry(date);
	if (entry != null) {
	    return entry.getValue();
	}
	return null;
    }

}
