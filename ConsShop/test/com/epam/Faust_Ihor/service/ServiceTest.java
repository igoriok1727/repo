package com.epam.Faust_Ihor.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.epam.Faust_Ihor.dataAccess.DataAccessObject;
import com.epam.Faust_Ihor.dataAccess.console.MapAccess;
import com.epam.Faust_Ihor.entity.Notebook;
import com.epam.Faust_Ihor.entity.Order;
import com.epam.Faust_Ihor.entity.Pen;
import com.epam.Faust_Ihor.entity.PenType;
import com.epam.Faust_Ihor.entity.Pencil;
import com.epam.Faust_Ihor.entity.Thickness;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.storage.Bucket;
import com.epam.Faust_Ihor.storage.OrderStorage;

public class ServiceTest {

    private final Notebook NOTEBOOK1 = new Notebook("NBtitle1", 22, 40);
    private final Notebook NOTEBOOK2 = new Notebook("NBtitle2", 15, 70);
    private final Pen PEN1 = new Pen("Ptitle1", 22, "Black", PenType.BALL);
    private final Pen PEN2 = new Pen("Ptitle2", 15, "Blue", PenType.GEL);
    private final Pen PEN3 = new Pen("Ptitle1", 22, "Orange", PenType.FOUNTAIN);
    private final Pencil PENCIL1 = new Pencil("PLtitle2", 15, "Black",
	    Thickness.B);
    private static final Pencil PENCIL2 = new Pencil("PLtitle1", 10, "Blue",
	    Thickness.HH);
    private static final Pencil PENCIL3 = new Pencil("PLtitle2", 12.5,
	    "Orange", Thickness.HB);

    private static Map<Long, WritingGood> data = new LinkedHashMap<Long, WritingGood>(
	    20, 0.8f, true);

    private List<WritingGood> forOrder;
    
    Bucket bucket;
    OrderStorage orders;
    DataAccessObject dao;
    Service service;
    
    @Before
    public void before() {
	data.clear();
	data.put(NOTEBOOK1.code(), NOTEBOOK1);
	data.put(NOTEBOOK2.code(), NOTEBOOK2);
	data.put(PEN1.code(), PEN1);
	data.put(PEN2.code(), PEN2);
	data.put(PEN3.code(), PEN3);
	data.put(PENCIL1.code(), PENCIL1);
	data.put(PENCIL2.code(), PENCIL2);
	data.put(PENCIL3.code(), PENCIL3);
	
	forOrder = new ArrayList<WritingGood>();
	forOrder.add(NOTEBOOK1);
	
	bucket = new Bucket();
	orders = new OrderStorage();
	dao = new MapAccess(data, bucket, orders);
	service = new Service(dao);
    }

    @Test(expected=NullPointerException.class)
    public void NPEIsThrownWhenPutNulToServiceConstructor() {
	service = new Service(null);
    }
    
    @Test
    public void getAllTest() {
	List<WritingGood> wgList = service.getAllItems();
	List<WritingGood> expected = new ArrayList<WritingGood>(data.values());
	assertTrue(wgList.containsAll(expected) && expected.containsAll(wgList));
    }
    
    @Test
    public void addToBucketTest() {
	service.addToBucket(NOTEBOOK1.code());
	service.addToBucket(NOTEBOOK1.code());
	service.addToBucket(PEN2.code());
	assertTrue(bucket.getMap().size() == 2);
	
	assertTrue(bucket.getMap().get(NOTEBOOK1.code()) == 2);
	assertTrue(bucket.getMap().get(PEN2.code()) == 1);
    }
    
    @Test
    public void isBucketEmptyTest() {
	assertTrue(service.isBucketEmpty());
	service.addToBucket(PEN3.code());
	assertFalse(service.isBucketEmpty());
    }

    @Test
    public void buyAllTest() {
	service.addToBucket(PEN1.code());
	service.addToBucket(PEN3.code());
	assertTrue(service.buyAll(new Date()) == 44);
    }
    
    @Test
    public void findNearestOrderTest() throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
	Date date = sdf.parse("12-03");
	Order expected = new Order(forOrder, date);
	orders.add(date, expected);
	Order actual = service.findNearestOrder(date);
	assertTrue(actual.equals(expected));
	
    }
    
    @Test
    public void findNearestOrderReturnsNullIfNoOrderFound() throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
	Date date = sdf.parse("12-03");
	Order expected = new Order(forOrder, date);
	orders.add(date, expected);
	Order actual1 = service.findNearestOrder(sdf.parse("15-03"));
	assertTrue(actual1 == null);
    }
    
    @Test
    public void findOrdersBetweenDates() throws ParseException {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
	Date date = sdf.parse("12-03");
	Order expected = new Order(forOrder, date);
	orders.add(date, expected);
	List<Order> actual = service.findOrdersBetween(sdf.parse("10-03"), sdf.parse("15-03"));
	assertTrue(actual.size() == 1);
	assertTrue(actual.get(0).equals(expected));
    }
    
}
