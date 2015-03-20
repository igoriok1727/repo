package com.epam.Faust_Ihor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.Faust_Ihor.dao.ItemDao;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;

public class Service {

	private ItemDao data;

	public Service(ItemDao data) {
		this.data = data;
	}

	public List<WritingGood> getAllItems() {
		return data.getAllItems();

	}

	public void addToBucket(Long code) {
		data.addToBucket(code);
	}

	public double buyAll(Date date) {
		double total = 0;
		List<WritingGood> wgList = getListItemsFromTheBucket();
		for (WritingGood wg : wgList) {
			total += wg.getPrice();
		}
		data.addOrder(date, wgList);
		return total;
	}

	public Order findNearestOrder(Date date) {
		return data.nearestTo(date);
	}

	public List<Order> getOrdersBetween(Date first, Date last) {
		return data.getOrdersBetween(first, last);
	}

	public List<WritingGood> getListItemsFromTheBucket() {
		List<WritingGood> wgList = new ArrayList<WritingGood>();

		Iterator<Entry<Long, Integer>> it = data.getItemsFromBucket()
				.iterator();

		while (it.hasNext()) {
			Entry<Long, Integer> entry = it.next();
			wgList.add(data.get(entry.getKey()));
		}
		
		return wgList;
	}

}