package com.epam.Faust_Ihor.dataAccess;

import java.util.Date;
import java.util.List;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;

public interface DataAccessObject {

	WritingGood get(long code);
	
	List<WritingGood> getAll();
	
	WritingGood addToBucket(long code);
		
	void addOrder(Date date, List<WritingGood> wgList);
	
	Order nearestTo(Date date);
	
	List<Order> findOrdersBetween(Date first, Date last);
	
	List<WritingGood> getItemsFromBucket();
	
	void cleanBucket();
	
}
