package com.epam.Faust_Ihor.dao.console;

import java.util.Date;
import java.util.List;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class MapOrderDao {

    private OrderStorage orders;

    public MapOrderDao(OrderStorage orders) {
	if (orders == null) {
	    throw new NullPointerException("orders is null");
	}
	this.orders = orders;
    }
    
    public void add(Date date, List<WritingGood> wgList) {
	orders.add(date, new Order(wgList, date));
    }

    public Order nearestTo(Date date) {
	return orders.nearestTo(date);
    }

    public List<Order> getOrdersBetween(Date first, Date last) {
	return orders.getOrdersBetween(first, last);
    }
    
}
