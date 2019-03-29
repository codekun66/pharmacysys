package com.zp.pharmacysys.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * 时间工具类
 */
public class DateUtil extends JsonSerializer<Date> {
	/*
	 * 构造器
	 */
	private DateUtil() {
		
	}
	
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String value = dateFormat.format(date);
        gen.writeString(value);
    }
    
//    public static String FtpDate() {
//    	   Date date = new Date();
//           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//           String dateStr = sdf.format(date);
//           return dateStr ;
//    }

}