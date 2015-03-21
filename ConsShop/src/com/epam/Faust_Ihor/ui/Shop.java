package com.epam.Faust_Ihor.ui;

import com.epam.Faust_Ihor.service.Service;

public abstract class Shop {

    
    public static final int SHOW_ALL_GOODS = 1;
    public static final int ADD_GOOD_TO_BUCKET = 2;
    public static final int SHOW_BUCKET = 3;
    public static final int BUY = 4;
    public static final int SHOW_NEAREST_ORDER = 5;
    public static final int SHOW_ORDERS_BETWEEN = 6;
    public static final int SHOW_POPULAR = 7;
    public static final int EXIT = 0;
    public static final int DEFAULT_COMMAND = -1;
    
    public abstract void dialog(Service service);

    public static void showDialog() {
	System.out.println("Choose command:");
	System.out.println(SHOW_ALL_GOODS + ": show all goods\n"
		+ ADD_GOOD_TO_BUCKET + ": add item to the bucket\n"
		+ SHOW_BUCKET + ": Show bucket\n" 
		+ BUY + ": buy all in bucket\n" 
		+ SHOW_NEAREST_ORDER + ": find nearest order after date\n" 
		+ SHOW_ORDERS_BETWEEN + ": find orders between dates\n" 
		+ SHOW_POPULAR + ": popular goods\n" + EXIT + ": close\n");
    }

}
