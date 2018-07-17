package com.yf.utils;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {
	/*private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");
	
	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat(
			"HHmmss");
	
	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");*/

	/*
	 * 时间 转换 时间戳
	 * 
	 * @return
	 */
	public static String getTimeStamp(String time) throws ParseException {
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");  
		DateTime dateTime = DateTime.parse(time, format);
		return String.valueOf(dateTime.getMillis()) ;
		
	}
	/* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long s){
    	DateTime dateTime = new DateTime(s);
        return dateTime.toString("yyyy-MM-dd HH:mm:ss");
    }
	
    /**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static String getMillis() {
		return String.valueOf(DateTime.now().getMillis());
	}
	
	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return String.valueOf(DateTime.now().getYear());
	}

	public static String getMonthOfYear() {return String.valueOf(DateTime.now().getMonthOfYear());}

    public static String getDayOfMonth() {return String.valueOf(DateTime.now().getDayOfMonth());}

    /**
	 * 获取YYYY-MM-dd格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return DateTime.now().toString("YYYY-MM-dd");
	}
	
	/**
	 * 获取YYYYMMdd格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return DateTime.now().toString("YYYYMMdd");
	}

	/**
	 * 获取YYYY-MM-dd HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return DateTime.now().toString("YYYY-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取yyyyMMddHHmmss格式
	 * 
	 * @return
	 */
	public static String getTimes() {
		return DateTime.now().toString("yyyyMMddHHmmss");
	}
	
	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author ylt
	 */
	public static boolean compareDate(String s, String e) {
		DateTimeFormatter sf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");  
		DateTime fTime = DateTime.parse(s, sf);
		DateTime sTime = DateTime.parse(e, sf);
		
		if(fTime==null||sTime==null){
			return false;
		}
		return fTime.getMillis() >= sTime.getMillis();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateTimeFormatter sf = DateTimeFormat.forPattern("yyyy-MM-dd");  
		DateTime dateTime = DateTime.parse(date, sf);
		return dateTime.toDate();
	}

	
	public static int getDiffYear(String startTime, String endTime) {
		DateTimeFormatter sf = DateTimeFormat.forPattern("yyyy-MM-dd");  
		DateTime sTime = DateTime.parse(startTime, sf);
		DateTime eTime = DateTime.parse(endTime, sf);
		
		try {
			int years=(int) (((eTime.getMillis()-sTime.getMillis())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr){
    	DateTimeFormatter sf = DateTimeFormat.forPattern("yyyy-MM-dd"); 
    	DateTime beginDate = DateTime.parse(beginDateStr, sf);
    	DateTime endDate = DateTime.parse(endDateStr, sf);
    	Period p = new Period(beginDate, endDate, PeriodType.days());  
    	int days = p.getDays();  
        return days;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	DateTime dateTime = DateTime.now();
    	DateTime afterTime = dateTime.plusDays(Integer.parseInt(days));
        return afterTime.toString("yyyy-MM-dd");
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	DateTime dateTime = DateTime.now();
    	DateTime afterTime = dateTime.plusDays(Integer.parseInt(days));
        return String.valueOf(afterTime.getDayOfWeek());
    }
    
//    public static void main(String[] args) {
//    	try {
//    		String time =  "2017-12-11 03:21:31";
//    		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
//    		DateTime dateTime = DateTime.parse(time, format);
//    		DateTime dateTime1 = DateTime.now();
//        	DateTime afterTime = dateTime1.plusDays(Integer.parseInt("4"));
//
//    		System.out.println(afterTime.getDayOfWeek());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }

}
