package com.yf.common.utils;

import java.math.BigDecimal;
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
		StringBuffer sb = getStringBuffer(length);
        return sb.toString();
    }

	private static StringBuffer getStringBuffer(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
		return sb;
	}


	/**
	 * 生成随机的32位uuid
	 * @return
	 */
	public final static String getId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
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
