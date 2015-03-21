package com.epam.Faust_Ihor.ui;

import java.util.Scanner;

import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.console.ConsoleCommandContainer;

public class Dialog {

    private Service service;

    Scanner scn = new Scanner(System.in);

    public Dialog(Service service) {
	if (service == null) {
	    throw new NullPointerException();
	}
	this.service = service;
    }

    public void run() {
	@SuppressWarnings("resource")
	Scanner scn = new Scanner(System.in);

	int a = -1;
	do {
	    Shop.showDialog();
	    try {
		a = Integer.valueOf(scn.nextLine());
	    } catch (NumberFormatException nfe) {
		System.out.println("Cpmmand is incorrect");
		a = -1;
	    }
	    ConsoleCommandContainer.get(a).dialog(service);
	} while (a != 0);

    }
    
    /*Этот метод приводит к зацикливанию. Сканер сам по себе че-то считывает после ексепшна*/
    public void runNextInt() {
	Scanner scn = new Scanner(System.in);

	int a = -1;
	do {
	    Shop.showDialog();

	    if (scn.hasNextInt()) {
		a = scn.nextInt();
	    } else {
		a = -1;
	    }
	    ConsoleCommandContainer.get(a).dialog(service);
	} while (a != 0);

	scn.close();
    }

}
