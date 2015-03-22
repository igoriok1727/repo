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

public class MapDao implements GoodDao {

    private MapBucketDao bucket;
    
    private MapOrderDao orders;
    
    private MapGoodDao goods;

    public MapDao(Map<Long, WritingGood> goods, Bucket bucket, OrderStorage orders) {
	if (goods == null) {
	    throw new NullPointerException("data is null");
	}
	if (bucket == null) {
	    throw new NullPointerException("bucket is null");
	}
	if (orders == null) {
	    throw new NullPointerException("orders is null");
	}
	this.bucket = new MapBucketDao(bucket);
	this.orders = new MapOrderDao(orders);
	this.goods = new MapGoodDao(goods);
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
    
    public Set<Entry<Long, Integer>> getItemsFromBucket() {
	return bucket.getAllAsSet();
    }

    @Override
    public void cleanBucket() {
	bucket.cleanBucket();

    }
    
    public void addOrder(Date date, List<WritingGood> wgList) {
	orders.add(date, wgList);
    }

    public Order nearestTo(Date date) {
	return orders.nearestTo(date);
    }

    public List<Order> getOrdersBetween(Date first, Date last) {
	return orders.getOrdersBetween(first, last);
    }
    
}
