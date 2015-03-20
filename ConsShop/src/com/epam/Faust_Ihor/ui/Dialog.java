package com.epam.Faust_Ihor.ui;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;

public class Dialog {

	private Service service;

	Scanner scn = new Scanner(System.in);
	
	public Dialog(Service service) {
		this.service = service;
	}

	public void show() {
		for (WritingGood wg : service.getAllItems()) {
			System.out.println(wg);
		}
	}

	public void showDialog() {
		show();
		System.out.println("\nChoose command:");
		System.out
				.println("\n1: add item to the bucket\n"
						+ "2: buy all in bucket\n"
						+ "3: Show bucket\n"
						+ "4: find nearest order after date\n"
						+ "5: find orders between dates\n"
						+ "6: popular goods\n"
						+ "0: close");
	}

	public void addItemToBucketDialog() {
		System.out.println("Code: ");
		long code = scn.nextLong();
		service.addToBucket(code);
	}

	public void buyItemsInBucketDialog() {
		System.out.println("Date: ");
		double total = service.buyAll(new Date(scn.nextLong()));
		System.out.println("Order's made.\nTotal: " + total);
	}
	
	public void showItemsInTheBucket() {
		List<WritingGood> goods = service.getListItemsFromTheBucket();
		Iterator<WritingGood> it = goods.iterator();
		if (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void findNearestOrderDialog() {
		System.out.print("Enter date: ");
		Order order = service.findNearestOrder(new Date(scn.nextLong()));
		System.out.println("Date: " + order.getDate());
		order.printGoods();
	}

	public void findOrdersBetweenDialog() {
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
		}
	}
	
	public void showMostPopular() {
		List<WritingGood> list = service.getAllItems();
		ListIterator<WritingGood> it = list.listIterator(list.size());
		
		int i = 0;
		while (it.hasPrevious() && i < 5) {
			System.out.println(it.previous());
			i++;
		}
	}

}
