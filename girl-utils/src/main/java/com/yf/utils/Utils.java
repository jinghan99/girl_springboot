package com.yf.utils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类
 * @author hai
 *
 */
public class Utils {
	public static Pattern p_num = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
	public static Pattern p_int = Pattern.compile("-?[0-9]+");

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
	/**
	 * 取得访问ip
	 * @param request
	 * @return
	 */
	public final static String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    }   
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	/**
	 * 把传入的字符用MD5方式加密
	 * @param s
	 * @return
	 */
	 public final static String MD5(String s) {
			if(Utils.isNull(s)){
				return null;
			}
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
	        try {
	            byte[] btInput = s.getBytes();
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要
	            mdInst.update(btInput);
	            // 获得密文
	            byte[] md = mdInst.digest();
	            // 把密文转换成十六进制的字符串形式
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	/**
	 * 生成随机的32位uuid
	 * @return
	 */
	public final static String getId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	

	/**
	 * 验证参数是否为数字,是true
	 * @param object
	 * @return
	 */
	public final static boolean isNumber(Object object) {
		try {
			Matcher m = p_num.matcher(object.toString());
			return m.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 验证参数是否为正数,是true
	 * @param object
	 * @return
	 */
	public final static boolean isInteger(Object object) {
		try {
			Matcher m = p_int.matcher(object.toString());
			return m.matches();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 验证参数是否不为空,非空true
	 * @param obj
	 * @return
	 */
	public final static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
	/**
	 * 验证参数是否为空,空true
	 * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty 
	 * @param obj
	 * @return
	 */
	public final static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}  
   
        if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		}  
   
        if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}  
   
        if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}  
   
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {  
                return true;  
            }  
            boolean empty = true;  
            for (int i = 0; i < object.length; i++) {  
                if (!isNull(object[i])) {  
                    empty = false;  
                    break;  
                }  
            }  
            return empty;  
        }  
        return false;
	}
	
	
	/**
	 * 生成随机数
	 * @param number 生成的位数
	 * @return
	 */
	public final static String random(int number){
		String str = "";
		for(int i = 0;i < number;++i){
			str += (int)(Math.random()*10);
		}
		return str;
	}
	
	
	/**
	 * 去掉第一个字符
	 * @param s
	 * @return
	 */
	public final static String subOne(String s){
		if(Utils.isNotNull(s)){
			return s.substring(1);
		}
		return "";
	}
	
	/**
	 * 判断date1和date2是否在同一周
	 * @param date1
	 * @param date2
	 * @return true表示是一周，false不是一周
	 */
	 public final static boolean isSameDate(Date date1, Date date2)
	 {
	  Calendar cal1 = Calendar.getInstance();
	  Calendar cal2 = Calendar.getInstance();
	  cal1.setTime(date1);
	  cal2.setTime(date2);
	  int subYear = cal1.get(Calendar.YEAR)-cal2.get(Calendar.YEAR);//两个年相减
	  if(subYear == 0)//说明是同一年
	  {
	   if(cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		return true;
	}
	  }else if(subYear==1 && cal2.get(Calendar.MONTH)==11)//周是否相同，例子:cal1是"2005-1-1"，cal2是"2004-12-25"
	  {
	   if(cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		return true;
	}
	  } else if(subYear==-1 && cal1.get(Calendar.MONTH)==11) //周是否相同，例子:cal1是"2004-12-31"，cal2是"2005-1-1"
	  {
	   if(cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		return true;
	}
	  }
	  return false;
	 }
	 

	 /**
	  * 保留2位小数
	  * @param d
	  * @return
	  */
	 public final static double dformat(double d){
		 BigDecimal b = new BigDecimal(d);
		 return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	 
	 /**
	  * 保留2位小数，不以科学方式显示
	  * @param d
	  * @return
	  */
	 public final static String toformatString(double d){
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");//格式化设置
	     return decimalFormat.format(d); 
	 }
	 
	 /**
	  * 将时间转换成yyyy-MM格式
	  * @param date
	  * @return
	  */
	 public final static String getFormat(Date date){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		 return sdf.format(date);
	 }
	 
	 /**
	  * 得到字符串时间
	  * @param
	  * @return
	  */
	 public final static String getDate(){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return sdf.format(new Date());
	 }
	 

}
