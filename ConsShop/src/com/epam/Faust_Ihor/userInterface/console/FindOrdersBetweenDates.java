package com.epam.Faust_Ihor.userInterface.console;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.DateReader;
import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class FindOrdersBetweenDates extends ShopCommand {

    @Override
    public void dialog(Service service) {
	checkOnNull(service);

	List<Order> orders = findOrders(service);
	if (orders == null || orders.size() == 0) {
	    System.out.println("No orders found");
	} else {
	    show(orders);
	}

	System.out.println();
    }

    private List<Order> findOrders(Service service) {
	System.out.println("Searching orders between two dates: ");

	DateReader dr = new DateReader();
	Date first = dr.readDate("Enter first date(format " + dr.getFormat()
		+ "): ");
	Date second = dr.readDate("Enter second date(format " + dr.getFormat()
		+ "): ");
	List<Order> orders = service.findOrdersBetween(first, second);

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
