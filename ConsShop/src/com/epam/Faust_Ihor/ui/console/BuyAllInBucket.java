package com.epam.Faust_Ihor.ui.console;

import java.util.Date;
import java.util.Scanner;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class BuyAllInBucket extends Shop {

    @Override
    public void dialog(Service service) {

	if (service.isBucketEmpty()) {
	    System.out.println("Bucket is empty");
	} else {
	    System.out.println("Making an order");
	    System.out.print("Date: ");
	    try {
		@SuppressWarnings("resource")
		long date = Long.valueOf(new Scanner(System.in).nextLine());
		double total = service.buyAll(new Date(date));
		System.out.println("Order's made.\nTotal: " + total);
	    } catch (NumberFormatException nfe) {
		System.out.println("Incorrect date format");
	    }
	}

	System.out.println();
    }

}
