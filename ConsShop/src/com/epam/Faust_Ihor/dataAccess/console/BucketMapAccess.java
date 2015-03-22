package com.epam.Faust_Ihor.dataAccess.console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;

public class BucketMapAccess {

    private Bucket bucket;
    
    private Map<Long, WritingGood> goods;

    BucketMapAccess(Bucket bucket, Map<Long, WritingGood> goods) {
	if (bucket == null) {
	    throw new NullPointerException("bucket is null");
	}
	if (goods == null) {
	    throw new NullPointerException("goods is null");
	}
	this.bucket = bucket;
	this.goods = goods;
    }
    
    public void addToBucket(WritingGood wg) {
	bucket.addToBucket(wg);
    }
    
    public List<WritingGood> getAllAsList() {
	Iterator<Entry<Long, Integer>> it = bucket.getMap().entrySet()
		.iterator();
	List<WritingGood> wgList = new ArrayList<WritingGood>();
	while (it.hasNext()) {
	    Entry<Long, Integer> entry = it.next();
	    int count = entry.getValue();
	    for (int i = 0; i < count; i++) {
		/*variable "goods" is needed only there and I can't avoid using it*/
		wgList.add(goods.get(entry.getKey()));
	    }
	}
	return wgList;
    }

    public void cleanBucket() {
	bucket.clear();
    }
    
}
