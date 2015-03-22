package com.epam.Faust_Ihor.ui.console;

import java.util.Date;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.DateReader;
import com.epam.Faust_Ihor.ui.Shop;

public class BuyAllInBucket extends Shop {

    @Override
    public void dialog(Service service) {

	if (service.isBucketEmpty()) {
	    System.out.println("Bucket is empty");
	} else {
	    System.out.println("Making an order");
	    Date date = DateReader.readDate("Date(format " + DateReader.getFormat() + "): ");
	    double total = service.buyAll(date);
	    System.out.println("Order's made.\nTotal: " + total);
	}

	System.out.println();
    }
    
}
