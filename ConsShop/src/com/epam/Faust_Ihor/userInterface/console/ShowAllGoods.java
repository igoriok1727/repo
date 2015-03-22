package com.epam.Faust_Ihor.userInterface.console;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class ShowAllGoods extends ShopCommand {

    @Override
    public void dialog(Service service) {
	checkOnNull(service);
	System.out.println("All goods:");
	for (WritingGood wg : service.getAllItems()) {
		System.out.println(wg);
	}
	System.out.println();

    }

}
