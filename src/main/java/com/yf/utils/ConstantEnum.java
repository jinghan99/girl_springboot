package com.yf.utils;

public class ConstantEnum {
	
	/**
	 * 表示系统中执行请求后返回信息的状态类型
	 */
	public enum MsgType {
		/**
		 * 警告信息
		 */
		WARN("warn"),
		/**
		 * 成功信息
		 */
		SUCCESS("success"),
		/**
		 * 错误信息
		 */
		ERROR("error");

		private String key = "";

		private MsgType(String key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return this.key;
		}
	}
	
}
