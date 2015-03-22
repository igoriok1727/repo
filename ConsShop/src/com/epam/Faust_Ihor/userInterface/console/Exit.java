package com.epam.Faust_Ihor.userInterface.console;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.Shop;

public class Exit extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Good buy!\n");
    }

    
    
}
