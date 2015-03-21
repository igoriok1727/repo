package com.epam.Faust_Ihor.ui.console;

import java.util.Scanner;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class AddGoodToBucket extends Shop {

    @SuppressWarnings("resource")
    @Override
    public void dialog(Service service) {
	System.out.println("Adding a good to a bucket");
	System.out.print("Code: ");
	long code = new Scanner(System.in).nextLong();
	WritingGood wg = service.addToBucket(code);
	System.out.println("You've added to the bucket a new " + wg + "\n");
    }

}
