package com.epam.Faust_Ihor.userInterface.console;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class Exit extends ShopCommand {

    @Override
    public void dialog(Service service) {
	System.out.println("Good buy!\n");
    }
 
}
