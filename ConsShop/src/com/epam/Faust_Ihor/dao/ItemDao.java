package com.epam.Faust_Ihor.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.WritingGood;

public interface ItemDao {

	WritingGood get(Long code);
	
	List<WritingGood> getAll();
	
	WritingGood addToBucket(Long code);
		
	void addOrder(Date date, List<WritingGood> wgList);
	
	Order nearestTo(Date date);
	
	List<Order> getOrdersBetween(Date first, Date last);
	
	Set<Entry<Long, Integer>> getItemsFromBucket();
	
	void cleanBucket();
	
}
