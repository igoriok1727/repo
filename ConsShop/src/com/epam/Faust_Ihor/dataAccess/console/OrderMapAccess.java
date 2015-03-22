package com.epam.Faust_Ihor.dataAccess.console;

import java.util.Date;
import java.util.List;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class OrderMapAccess {

    private OrderStorage orders;

    public OrderMapAccess(OrderStorage orders) {
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

    public List<Order> findOrdersBetween(Date first, Date last) {
	return orders.findOrdersBetween(first, last);
    }
    
}
