package com.epam.Faust_Ihor.userInterface.console;

import java.util.List;
import java.util.ListIterator;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.Shop;

public class FindPopularGoods extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Popular goods: ");
	List<WritingGood> list = service.getAllItems();
	ListIterator<WritingGood> it = list.listIterator(list.size());
	
	int i = 0;
	while (it.hasPrevious() && i < 5) {
		System.out.println(it.previous());
		i++;
	}
	System.out.println();
    }

}
