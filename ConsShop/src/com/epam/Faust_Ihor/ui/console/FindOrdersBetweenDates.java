package com.epam.Faust_Ihor.ui.console;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class FindOrdersBetweenDates extends Shop {

    @Override
    public void dialog(Service service) {

	List<Order> orders = find(service);
	if (orders == null || orders.size() == 0) {
	    System.out.println("No orders found");
	} else {
	    show(orders);
	}

	System.out.println();
    }

    /* Is it better to split this function to several smaller functions? */
    private List<Order> find(Service service) {
	System.out.println("Searching orders between two dates: ");
	@SuppressWarnings("resource")
	Scanner scn = new Scanner(System.in);
	List<Order> orders = null;
	try {
	    System.out.print("Enter first date: ");
	    Date first = new Date(scn.nextLong());
	    System.out.print("Enter second date: ");
	    Date second = new Date(scn.nextLong());
	    orders = service.getOrdersBetween(first, second);
	} catch (NumberFormatException nfe) {
	    System.out.println("Incorrect date format");
	}
	return orders;
    }

    private void show(List<Order> orders) {
	Iterator<Order> it = orders.iterator();
	while (it.hasNext()) {
	    Order order = it.next();
	    System.out.println(order.getDate());
	    order.printGoods();
	    System.out.println();
	}
    }
}
