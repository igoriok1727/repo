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
	System.out.println("Searching orders between two dates: ");
	@SuppressWarnings("resource")
	Scanner scn = new Scanner(System.in);
	System.out.print("Enter first date: ");
	Date first = new Date(scn.nextLong());
	System.out.print("Enter second date: ");
	Date second = new Date(scn.nextLong());
	List<Order> orders = service.getOrdersBetween(first, second);
	Iterator<Order> it = orders.iterator();
	while (it.hasNext()) {
		Order order = it.next();
		System.out.println(order.getDate());
		order.printGoods();
		System.out.println();
	}
	System.out.println();
    }

}
