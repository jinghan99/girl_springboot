package com.yf.utils;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JSONUtils {
	public static void main(String[] args) {
	}

	public static String bean2json(Object bean) {
		Gson gson = new GsonBuilder().registerTypeAdapter(java.sql.Date.class, new SQLDateSerializer())
				.registerTypeAdapter(Date.class, new UtilDateSerializer())
				.registerTypeAdapter(java.sql.Timestamp.class, new TimestampSerializer()).setDateFormat(DateFormat.LONG)
				.create();
		return gson.toJson(bean);
	}

	public static <T> T json2bean(String json, Type type) {
		Gson gson = new GsonBuilder().registerTypeAdapter(java.sql.Date.class, new SQLDateDeserializer())
				.registerTypeAdapter(Date.class, new UtilDateDeserializer()).setDateFormat(DateFormat.LONG)
				.create();
		return gson.fromJson(json, type);
	}

	/**
	 * json转为map，指针对key，value形式的json
	 *
	 * @param json
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map json2Map(String json) {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(String.class, new StringDeserializer());
		gb.setDateFormat(DateFormat.LONG);
		Gson g = gb.create();
		Map<String, String> map = g.fromJson(json, new TypeToken<Map<String, String>>() {
		}.getType());
		return map;
	}
	/**
	 * json array 转换成list<map>对象
	 * @Title: objectToMap
	 * @Description:str 格式    [{"key":"产地","value":"呼和浩特"},{"key":"种类","value":"大"}]
	 * @param
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static List<Map> jsonArray2List(String str) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    List<Map> conList = mapper.readValue(str, List.class);
	    return conList;
	}




	public static int toInt(String v) {
		if (!isEmpty(v)) {
			try {
				return Integer.parseInt(v.trim(), 10);
			} catch (Exception e) {
				return dealIntErr(v);
			}
		}
		return 0;
	}

	private static int dealIntErr(String str) {
		String num = str.replaceAll("\\D", "");
		try {
			return Integer.parseInt(num, 10);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static String formatDate(Date dt, String format) {
		if (isEmpty(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt);
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}

		if (obj instanceof String) {
			String str = (String) obj;
			return str.trim().length() == 0 || str.toLowerCase().equals("null");
		} else if (obj instanceof List) {
			List<?> ls = (List<?>) obj;
			return ls.size() == 0;
		} else if (obj instanceof Set) {
			Set<?> ls = (Set<?>) obj;
			return ls.size() == 0;
		} else if (obj instanceof Map) {
			Map<?, ?> ls = (Map<?, ?>) obj;
			return ls.size() == 0;
		} else if (obj instanceof String[]) {
			String[] ls = (String[]) obj;
			return ls.length == 0;
		} else if (obj instanceof Integer) {
			return (Integer) obj == 0;
		} else if (obj instanceof Object[]) {
			Object[] ls = (Object[]) obj;
			return ls.length == 0;
		}
		return false;
	}

	public static boolean isNotEmpty(Object objs) {
		return !isEmpty(objs);
	}

	public static Date getDate(String dtStr) {
		try {
			if (dtStr.trim().length() == 10) {
				dtStr = dtStr + " 00:00:00";
			} else if (dtStr.trim().length() > 19) {
				dtStr = dtStr.substring(0, 19);
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateInstance = df.parse(dtStr);
			return dateInstance;
		} catch (Exception ex) {
			return null;
		}
	}
}