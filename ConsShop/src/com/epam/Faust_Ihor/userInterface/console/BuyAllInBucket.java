package com.epam.Faust_Ihor.userInterface.console;

import java.util.Date;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.DateReader;
import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class BuyAllInBucket extends ShopCommand {

    @Override
    public void dialog(Service service) {
	checkOnNull(service);

	if (service.isBucketEmpty()) {
	    System.out.println("Bucket is empty");
	} else {
	    System.out.println("Making an order");
	    DateReader dr = new DateReader();
	    Date date = dr.readDate("Date(format " + dr.getFormat() + "): ");
	    double total = service.buyAll(date);
	    System.out.println("Order's made.\nTotal: " + total);
	}

	System.out.println();
    }
    
}
