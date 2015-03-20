package com.epam.Faust_Ihor.dao.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.Faust_Ihor.dao.ItemDao;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class ListItemDao implements ItemDao {

	private Map<Long, WritingGood> data;
	
	private Bucket bucket;
	private OrderStorage orders;
	
	public ListItemDao(Map<Long, WritingGood> data, Bucket bucket, OrderStorage orders) {
		this.data = data;
		this.bucket = bucket;
		this.orders = orders;
	}
	
	public WritingGood get(Long code) {
		return data.get(code);
	}
	
	public List<WritingGood> getAll() {
		return new ArrayList<WritingGood>(data.values());
	}
	
	public void addToBucket(Long code) {
		bucket.addToBucket(data.get(code));
	}
	
	public void addOrder(Date date, List<WritingGood> wgList) {
		orders.add(date, new Order(wgList, date));
	}
	
	public Order nearestTo(Date date) {
		return orders.nearestTo(date);
	}
	
	public List<Order> getOrdersBetween(Date first, Date last) {
		return orders.findOrdersBetween(first, last); 
	}

	public Set<Entry<Long, Integer>> getItemsFromBucket() {
		return bucket.getMap().entrySet();
	}
}
