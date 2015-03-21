package com.epam.Faust_Ihor.dao.console;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.Faust_Ihor.dao.GoodDao;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class MapGoodDao implements GoodDao {

    private Map<Long, WritingGood> data;

    private Bucket bucket;
    private OrderStorage orders;

    public MapGoodDao(Map<Long, WritingGood> data, Bucket bucket,
	    OrderStorage orders) {
	if (data == null) {
	    throw new NullPointerException("data is null");
	}
	if (bucket == null) {
	    throw new NullPointerException("bucket is null");
	}
	if (orders == null) {
	    throw new NullPointerException("orders is null");
	}
	this.data = data;
	this.bucket = bucket;
	this.orders = orders;
    }

    public WritingGood get(long code) {
	return data.get(code);
    }

    public List<WritingGood> getAll() {
	return new ArrayList<WritingGood>(data.values());
    }

    public WritingGood addToBucket(long code) {
	WritingGood wg = data.get(code);
	if (wg != null) {
	    bucket.addToBucket(wg);
	}
	return wg;
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

    @Override
    public void cleanBucket() {
	bucket.clear();

    }
}
