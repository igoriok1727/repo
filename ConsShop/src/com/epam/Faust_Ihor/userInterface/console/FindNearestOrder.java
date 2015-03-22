package com.epam.Faust_Ihor.userInterface.console;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.DateReader;
import com.epam.Faust_Ihor.userInterface.Shop;

public class FindNearestOrder extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Searching nearest order after a given date: ");

	DateReader dr = new DateReader();
	
	Order order = service.findNearestOrder(dr
		.readDate("Date(format " + dr.getFormat() + "): "));
	if (order == null) {
	    System.out.println("No orders found");
	} else {
	    System.out.println("Date: " + order.getDate());
	    order.printGoods();
	}
	System.out.println();
    }
}
