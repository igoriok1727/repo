package com.epam.Faust_Ihor.userInterface.console;

import java.util.Iterator;
import java.util.List;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class ShowBucket extends ShopCommand {

    @Override
    public void dialog(Service service) {
	checkOnNull(service);
	if (service.isBucketEmpty()) {
	    System.out.println("Bucket is empty");
	} else {
	    showBucket(service);
	}
	System.out.println();
    }

    private void showBucket(Service service) {
	System.out.println("Bucket: ");
	List<WritingGood> goods = service.getListItemsFromTheBucket();
	Iterator<WritingGood> it = goods.iterator();
	while (it.hasNext()) {
	    System.out.println(it.next());
	}
    }

}
