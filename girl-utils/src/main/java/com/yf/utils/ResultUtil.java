package com.yf.utils;


import com.yf.constant.RetEnum;

/**
 * @Description: 系统 api 返回 封装
 * @author: jinghan
 * @date 2019/4/24 15:29
 */
public class ResultUtil {
    /**
	 * 数据交互成功返回
	 * @param object json返回的数据
	 * */
	public static Result success(Object object){
		if(object==null){
			object = "";
		}
		return new Result(RetEnum.RET_SUCCESS.getCode(),RetEnum.RET_SUCCESS.getMessage(),object);
	}


	/**
	 * 异常处理
	 * @param retEnum
	 * @return
	 */
	public static Result error(RetEnum retEnum){
		return new Result(retEnum.getCode(),retEnum.getMessage(),"");
	}
	/**
	 * 异常处理
	 * @param retEnum
	 * @return
	 */
	public static Result error(RetEnum retEnum,Object result){
		return new Result(retEnum.getCode(),retEnum.getMessage(),result);
	}


	/**
	 * 系统异常 
	 * */
	public static Result systemError(String message){
		return new Result(RetEnum.RET_UNKNOWN_ERROR.getCode(),message,"");
	}
	/**
	 * 系统异常
	 * */
	public static Result systemError(String message,Object result){
		return new Result(RetEnum.RET_UNKNOWN_ERROR.getCode(),message,result);
	}

	/**
	 * 系统异常
	 * */
	public static Result systemError(Object result){
		return new Result(RetEnum.RET_UNKNOWN_ERROR.getCode(),RetEnum.RET_UNKNOWN_ERROR.getMessage(),result);
	}

	/**
	 * String  字符串 转  Resulit
	 * @param str
	 * @return
	 */
	public static Result strToResult(String str){
		if( str == null ||  str.length()==0){
			return null;
		}
		return  JSONUtils.json2bean(str,Result.class);
	}

	/**
	 * 判断成功
	 * @param result
	 * @return
	 */
	public static boolean isSuccess(Result result){
		if(result ==null){
			return false;
		}
		if(RetEnum.RET_SUCCESS.getCode().equals(result.getCode())){
			return true;
		}
		return false;
	}

	/**
	 * 判断未成功
	 * @param result
	 * @return
	 */
	public static boolean isNotSuccess(Result result){
		return !isSuccess(result);
	}
}