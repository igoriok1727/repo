package com.epam.Faust_Ihor.ui.console;

import java.util.Date;
import java.util.Scanner;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class BuyAllInBucket extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Making an order");
	System.out.print("Date: ");
	@SuppressWarnings("resource")
	double total = service.buyAll(new Date(new Scanner(System.in).nextLong()));
	System.out.println("Order's made.\nTotal: " + total);
	System.out.println();
    }

}
