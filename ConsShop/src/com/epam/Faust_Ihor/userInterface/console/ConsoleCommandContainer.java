package com.epam.Faust_Ihor.userInterface.console;

import java.util.HashMap;
import java.util.Map;

import com.epam.Faust_Ihor.userInterface.ShopCommand;

public class ConsoleCommandContainer {

    private static Map<Integer, ShopCommand> map = new HashMap<Integer, ShopCommand>();
    
    private static final ShopCommand DEFAUL_COMMAND = new DefaultCommand(); 
    
    static {
	map.put(ShopCommand.DEFAULT_COMMAND, DEFAUL_COMMAND);
	map.put(ShopCommand.SHOW_ALL_GOODS, new ShowAllGoods());
	map.put(ShopCommand.ADD_GOOD_TO_BUCKET, new AddGoodToBucket());
	map.put(ShopCommand.SHOW_BUCKET, new ShowBucket());
	map.put(ShopCommand.BUY, new BuyAllInBucket());
	map.put(ShopCommand.SHOW_NEAREST_ORDER, new FindNearestOrder());
	map.put(ShopCommand.SHOW_ORDERS_BETWEEN, new FindOrdersBetweenDates());
	map.put(ShopCommand.SHOW_POPULAR, new FindPopularGoods());
	map.put(ShopCommand.EXIT, new Exit());
    }
    
    public static ShopCommand get(Integer commandNumber) {
	if (map.containsKey(commandNumber)) {
	    return map.get(commandNumber);
	} 
	return DEFAUL_COMMAND;
    }
    
}
