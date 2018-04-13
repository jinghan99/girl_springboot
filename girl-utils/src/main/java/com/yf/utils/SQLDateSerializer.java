package com.yf.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.sql.Date;

public class SQLDateSerializer implements JsonSerializer<Date> {

    @Override
	public JsonElement serialize(Date src, Type typeOfSrc,
                                 JsonSerializationContext context) {
    	
        return new JsonPrimitive(JSONUtils.formatDate(src, null));
    }
}