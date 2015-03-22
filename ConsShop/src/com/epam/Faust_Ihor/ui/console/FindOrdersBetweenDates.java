package com.epam.Faust_Ihor.ui.console;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.DateReader;
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

    private List<Order> find(Service service) {
	System.out.println("Searching orders between two dates: ");

	Date first = DateReader.readDate("Enter first date(format " + DateReader.getFormat() + "): ");
	Date second = DateReader.readDate("Enter second date(format " + DateReader.getFormat() + "): ");
	List<Order> orders = service.getOrdersBetween(first, second);

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
