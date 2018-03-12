package com.yf.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class SQLDateDeserializer implements JsonDeserializer<java.sql.Date> {

	@Override
	public java.sql.Date deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
		Date d = JSONUtils.getDate(json.getAsString());
		return new java.sql.Date(d.getTime());
	}
}