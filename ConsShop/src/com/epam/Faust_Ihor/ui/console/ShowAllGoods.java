package com.epam.Faust_Ihor.ui.console;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class ShowAllGoods extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("All goods:");
	for (WritingGood wg : service.getAllItems()) {
		System.out.println(wg);
	}
	System.out.println();

    }

}
