package com.epam.Faust_Ihor.ui.console;

import java.util.HashMap;
import java.util.Map;

import com.epam.Faust_Ihor.ui.Shop;

public class ConsoleCommandContainer {

    private static Map<Integer, Shop> map = new HashMap<Integer, Shop>();
    
    private static final Shop DEFAUL_COMMAND = new DefaultCommand(); 
    
    static {
	map.put(Shop.DEFAULT_COMMAND, DEFAUL_COMMAND);
	map.put(Shop.SHOW_ALL_GOODS, new ShowAllGoods());
	map.put(Shop.ADD_GOOD_TO_BUCKET, new AddGoodToBucket());
	map.put(Shop.SHOW_BUCKET, new ShowBucket());
	map.put(Shop.BUY, new BuyAllInBucket());
	map.put(Shop.SHOW_NEAREST_ORDER, new FindNearestOrder());
	map.put(Shop.SHOW_ORDERS_BETWEEN, new FindOrdersBetweenDates());
	map.put(Shop.SHOW_POPULAR, new FindPopularGoods());
	map.put(Shop.EXIT, new Exit());
    }
    
    public static Shop get(Integer commandNumber) {
	if (map.containsKey(commandNumber)) {
	    return map.get(commandNumber);
	} 
	return DEFAUL_COMMAND;
    }
    
}
