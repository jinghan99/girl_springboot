package com.yf.utils;

import java.util.Random;
import java.util.UUID;

public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	/**
	 * 获取订单ID生成编码
	 * @return
	 */
	public static String get12ORID(){
		Random r = new Random();
		Random t = new Random();
		return r.nextInt(10)+ DateUtil.getMillis().substring(6, 12)+(t.nextInt(89999) + 10000);
	}
	
	/**
	 * 获取注册ID生成编码
	 * @return
	 */
	public static String get6ORID(){
		Random r = new Random();
		Random t = new Random();
		return r.nextInt(10)+ DateUtil.getMillis().substring(10, 12)+(t.nextInt(8999) + 1000);
	}
	
//	public static void main(String[] args) {
//		//System.out.println(get32UUID());
//		for(int i=0;i<10;i++){
//			System.out.println(UuidUtil.get6ORID());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}

