package com.epam.Faust_Ihor.userInterface.console;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.Shop;

public class DefaultCommand extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Choose command from the list please\n");

    }

}
