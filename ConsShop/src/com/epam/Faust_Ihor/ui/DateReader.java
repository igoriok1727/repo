package com.epam.Faust_Ihor.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateReader {
    
    
    private static String dateFormat = "dd-MM-yyyy HH:mm";
    
    public static Date readDate(String dialogString) {
	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	while (true) {
	    System.out.print(dialogString);
	    @SuppressWarnings("resource")
	    String str = new Scanner(System.in).nextLine();
	    try {
		return sdf.parse(str);
	    } catch (ParseException e) {
		System.out.println("Incorrect date format.");
		System.out.println("Enter date in format: " + dateFormat);
	    }
	}
    }
    
    public static String getFormat() {
	return dateFormat;
    }
    
}
