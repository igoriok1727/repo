package com.epam.Faust_Ihor.ui.console;

import java.util.Iterator;
import java.util.List;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.ui.Shop;

public class ShowBucket extends Shop {

    @Override
    public void dialog(Service service) {
	System.out.println("Bucket: ");
	List<WritingGood> goods = service.getListItemsFromTheBucket();
	Iterator<WritingGood> it = goods.iterator();
	while (it.hasNext()) {
		System.out.println(it.next());
	}
	System.out.println();
    }

}
