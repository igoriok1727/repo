package com.epam.Faust_Ihor.ui.console;

import java.util.Date;
import java.util.Scanner;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class FindNearestOrder extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Searching nearest order after a given date: ");
	System.out.print("Enter date: ");

	try {
	    @SuppressWarnings("resource")
	    long date = Long.valueOf(new Scanner(System.in).nextLine());
	    Order order = service.findNearestOrder(new Date(date));
	    System.out.println("Date: " + order.getDate());
	    order.printGoods();
	} catch (NumberFormatException nfe) {
	    System.out.println("Incorrect format");
	}

	System.out.println();
    }
}
