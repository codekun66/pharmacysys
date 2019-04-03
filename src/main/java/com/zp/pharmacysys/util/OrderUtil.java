package com.zp.pharmacysys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class OrderUtil {
    public static String createOrder() throws Exception {
    	 Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         String dateStr = sdf.format(date); // D:\\uploads\\20180824 String
         String randomUUID = UUID.randomUUID().toString();
         String Order = "P" + dateStr;
    	return Order;
    }
    
}
