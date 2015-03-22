package com.epam.Faust_Ihor.dao.console;

import java.util.Set;
import java.util.Map.Entry;

import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;

public class MapBucketDao {

    private Bucket bucket;

    public MapBucketDao(Bucket bucket) {
	if (bucket == null) {
	    throw new NullPointerException("bucket is null");
	}
	this.bucket = bucket;
    }
    
    public void addToBucket(WritingGood wg) {
	bucket.addToBucket(wg);
    }
    
    public Set<Entry<Long, Integer>> getAllAsSet() {
	return bucket.getMap().entrySet();
    }

    public void cleanBucket() {
	bucket.clear();
    }
    
}
