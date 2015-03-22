package com.epam.Faust_Ihor.service;

import java.util.Date;
import java.util.List;

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

    public List<Order> findOrdersBetween(Date first, Date last) {
	return data.findOrdersBetween(first, last);
    }

    public List<WritingGood> getListItemsFromTheBucket() {
	return data.getItemsFromBucket();
    }

}
