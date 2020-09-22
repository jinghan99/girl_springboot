package com.yf.chrome.constant;

/**
 * RPC调用返回码枚举类
 *
 * @author: jinghan
 * @date: 2019/8/1  9:40
 */
public enum RetEnum {

    // 0000: 成功
    RET_SUCCESS("0000", "成功"),


    RET_BIZ_ADD_WAREHOUSE_FAIL("1006", "增加库存失败"),

    RET_BIZ_FIND_WAREHOUSE_FAIL("1007", "暂时没有符合的库存"),

    RET_BIZ_REQUEST_PARAMETER_FAIL("1008", "请求参数异常"),

    RET_BIZ_SIGN_PARAMETER_FAIL("1009", "验签失败"),

    RET_NOT_FOUND_ERROR("1010", "无对应请求方式"),


    RET_BIZ_COOKIE_LOGIN_FAIL("1011", "cookie 登录过期"),


    RET_BIZ_COOKIE_TIME_FAIL("1012", "cookie 30 分钟 限制"),

    RET_BIZ_NO_COOKIE_FAIL("1013", "no login cookie"),
    // 未知错误
    RET_UNKNOWN_ERROR("9999", "未知错误")

    // 充值错误


    ;




    private String code;
    private String message;

    private RetEnum(String code, String message) { this.code = code;
        this.message = message; }

    public String getCode()
    {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static RetEnum getRetEnum(String code) {
        if (code == null) {
            return null;
        }

        RetEnum[] values = RetEnum.values();
        for (RetEnum e : values) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
