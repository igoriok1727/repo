package com.epam.Faust_Ihor.entity;

import java.util.Date;
import java.util.List;

public class Order {

	private Date date;
	
	private List<WritingGood> wgList;
	
	public Order(List<WritingGood> wgList, Date date) {
		this.wgList = wgList;
		this.date = date;
	}
	
	public List<WritingGood> getGoods() {
		return wgList;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void printGoods() {
		for (WritingGood wg : wgList) {
			System.out.println(wg);
		}
	}
	
}
