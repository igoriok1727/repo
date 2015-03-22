package com.epam.Faust_Ihor.dao.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.Faust_Ihor.entity.WritingGood;

public class MapGoodDao {

    private Map<Long, WritingGood> goods;


    public MapGoodDao(Map<Long, WritingGood> goods) {
	if (goods == null) {
	    throw new NullPointerException("goods is null");
	}
	
	this.goods = goods;
    }

    public WritingGood get(long code) {
	return goods.get(code);
    }

    public List<WritingGood> getAll() {
	return new ArrayList<WritingGood>(goods.values());
    }
  
}
