package com.epam.Faust_Ihor.dataAccess.console;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.epam.Faust_Ihor.dataAccess.DataAccessObject;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class MapAccess implements DataAccessObject {

    private BucketMapAccess bucket;
    
    private OrderMapAccess orders;
    
    private GoodInMapAccess goods;

    public MapAccess(Map<Long, WritingGood> goods, Bucket bucket, OrderStorage orders) {
	if (goods == null) {
	    throw new NullPointerException("data is null");
	}
	if (bucket == null) {
	    throw new NullPointerException("bucket is null");
	}
	if (orders == null) {
	    throw new NullPointerException("orders is null");
	}
	this.bucket = new BucketMapAccess(bucket, goods);
	this.orders = new OrderMapAccess(orders);
	this.goods = new GoodInMapAccess(goods);
    }
    
    public WritingGood get(long code) {
	return goods.get(code);
    }

    public List<WritingGood> getAll() {
	return new ArrayList<WritingGood>(goods.getAll());
    }
    
    public WritingGood addToBucket(long code) {
	WritingGood wg = goods.get(code);
	if (wg != null) {
	    bucket.addToBucket(wg);
	}
	return wg;
    }
    
    public List<WritingGood> getItemsFromBucket() {
	return bucket.getAllAsList();
    }

    public void cleanBucket() {
	bucket.cleanBucket();

    }
    
    public void addOrder(Date date, List<WritingGood> wgList) {
	orders.add(date, wgList);
    }

    public Order nearestTo(Date date) {
	return orders.nearestTo(date);
    }

    public List<Order> findOrdersBetween(Date first, Date last) {
	return orders.findOrdersBetween(first, last);
    }
    
}
