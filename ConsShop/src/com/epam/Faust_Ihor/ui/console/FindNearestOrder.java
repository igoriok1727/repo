package com.epam.Faust_Ihor.ui.console;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.DateReader;
import com.epam.Faust_Ihor.ui.Shop;

public class FindNearestOrder extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Searching nearest order after a given date: ");

	Order order = service.findNearestOrder(DateReader
		.readDate("Date(format " + DateReader.getFormat() + "): "));
	if (order == null) {
	    System.out.println("No orders found");
	} else {
	    System.out.println("Date: " + order.getDate());
	    order.printGoods();
	}
	System.out.println();
    }
}
