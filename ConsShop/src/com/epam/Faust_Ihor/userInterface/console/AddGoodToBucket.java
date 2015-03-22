package com.epam.Faust_Ihor.userInterface.console;

import java.util.Scanner;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.Shop;

public class AddGoodToBucket extends Shop {

    @SuppressWarnings("resource")
    @Override
    public void dialog(Service service) {
	System.out.println("Adding a good to a bucket");
	System.out.print("Code: ");
	long code = 0;
	try {
	    code = Long.valueOf(new Scanner(System.in).nextLine());
	    WritingGood wg = service.addToBucket(code);

	    if (wg == null) {
		System.out.println("No good for this code\n");
	    } else {
		System.out.println("You've added to the bucket a new " + wg
			+ "\n");
	    }
	} catch (NumberFormatException nfe) {
	    System.out.println("Code is incorrect\n");
	}

    }

}
