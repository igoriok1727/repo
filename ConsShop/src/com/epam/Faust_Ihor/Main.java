package com.epam.Faust_Ihor;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.Faust_Ihor.dataAccess.DataAccessObject;
import com.epam.Faust_Ihor.dataAccess.console.MapAccess;
import com.epam.Faust_Ihor.entity.Notebook;
import com.epam.Faust_Ihor.entity.Pen;
import com.epam.Faust_Ihor.entity.PenType;
import com.epam.Faust_Ihor.entity.Pencil;
import com.epam.Faust_Ihor.entity.Thickness;
import com.epam.Faust_Ihor.entity.WritingGood;
import com.epam.Faust_Ihor.service.Service;
import com.epam.Faust_Ihor.storage.Bucket;
import com.epam.Faust_Ihor.storage.OrderStorage;
import com.epam.Faust_Ihor.userInterface.Dialog;

public class Main {

    private static final Notebook NOTEBOOK1 = new Notebook("NBtitle1", 22, 40);
    private static final Notebook NOTEBOOK2 = new Notebook("NBtitle2", 15, 70);
    private static final Pen PEN1 = new Pen("Ptitle1", 22, "Black", PenType.BALL);
    private static final Pen PEN2 = new Pen("Ptitle2", 15, "Blue", PenType.GEL);
    private static final Pen PEN3 = new Pen("Ptitle1", 22, "Orange", PenType.FOUNTAIN);
    private static final Pencil PENCIL1 = new Pencil("PLtitle2", 15, "Black",
	    Thickness.B);
    private static final Pencil PENCIL2 = new Pencil("PLtitle1", 10, "Blue",
	    Thickness.HH);
    private static final Pencil PENCIL3 = new Pencil("PLtitle2", 12.5,
	    "Orange", Thickness.HB);

    private static Map<Long, WritingGood> data = new LinkedHashMap<Long, WritingGood>(20, 0.8f, true);

    static {
	data.put(NOTEBOOK1.code(), NOTEBOOK1);
	data.put(NOTEBOOK2.code(), NOTEBOOK2);
	data.put(PEN1.code(), PEN1);
	data.put(PEN2.code(), PEN2);
	data.put(PEN3.code(), PEN3);
	data.put(PENCIL1.code(), PENCIL1);
	data.put(PENCIL2.code(), PENCIL2);
	data.put(PENCIL3.code(), PENCIL3);
    }

    public static void main(String[] args) throws ParseException {
	Bucket bucket = new Bucket();
	OrderStorage orders = new OrderStorage();
	DataAccessObject dao = new MapAccess(data, bucket, orders);
	Service service = new Service(dao);
	Dialog dialog = new Dialog(service);
	
	dialog.run();
	
    }

}
