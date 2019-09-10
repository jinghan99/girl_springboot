package com.yf.utils;


public class Result {
    /*返回码*/
	private String code;
	/*返回信息提示*/
	private String msg;
	/*返回的数据*/
	private Object result;
	
	public Result(){}
	
	public Result(String code,String msg,Object result) {
		this.setCode(code);
		this.setMsg(msg);
		this.setResult(result);
	}
	
	@Override
	public String toString() {
		return "Result [code=" + getCode() + ", msg=" + getMsg() + ", result=" + getResult() + "]";
	}
	public String toJSONString() {
		return JSONUtils.bean2json(this);
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}