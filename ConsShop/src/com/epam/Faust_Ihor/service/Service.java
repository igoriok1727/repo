package com.epam.Faust_Ihor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.epam.Faust_Ihor.dataAccess.DataAccessObject;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;

public class Service {

    private DataAccessObject data;

    public Service(DataAccessObject data) {
	if (data == null) {
	    throw new NullPointerException("data is null");
	}
	this.data = data;
    }

    public List<WritingGood> getAllItems() {
	return data.getAll();

    }

    public WritingGood addToBucket(Long code) {
	return data.addToBucket(code);
    }

    public boolean isBucketEmpty() {
	return data.getItemsFromBucket().size() == 0;
    }

    /* Is it necessary to consider the case when date is null? */
    public double buyAll(Date date) {

	List<WritingGood> wgList = getListItemsFromTheBucket();
	double total = 0;

	for (WritingGood wg : wgList) {
	    total += wg.getPrice();
	}
	data.addOrder(date, wgList);
	data.cleanBucket();

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
	    int count = entry.getValue();
	    for (int i = 0; i < count; i++) {
		wgList.add(data.get(entry.getKey()));
	    }
	}

	return wgList;
    }

}
