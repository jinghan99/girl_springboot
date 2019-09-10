package com.yf.constant;

/**
 * RPC调用返回码枚举类
 * 对应方法调用返回值中的rpcRetCode和rpcRetMsg
 * Created by admin on 2016/4/27.
 */
public enum RetEnum {

    // 0000: 成功
    RET_SUCCESS("0000", "成功"),

    // 失败(00开始标示通讯层相关错误码)
    RET_REMOTE_UNUSABLE("0001", "远程服务不可用"),
    RET_REMOTE_INVALID("0002", "客户端非法调用"),
    RET_NO_BIZ_SEQUENCE_NO("0003", "远程服务调用业务流水号不存在"),
    RET_REMOTE_CHECK_SIGN_FAIL("0004", "远程服务调用签名验证失败"),
    RET_REMOTE_RPC_SEQ_NO_REPEATED("0005", "随机通讯码在指定时间内重复"),
    RET_REMOTE_SIGN_INVALID("0006", "远程服务调用签名计算方式错误"),
    RET_REMOTE_DEAL_EXCEPTION("0007", "远程服务调用处理异常"),
    RET_REMOTE_PROTOCOL_INVALID("0008", "客户端调用协议非法"),
    RET_REMOTE_HTTP_METHOD_INVALID("0009", "客户端请求方式非法"),

    // 失败(01开始标示参数校验相关错误码)
    RET_PARAM_NOT_FOUND("0101", "参数不存在"),
    RET_PARAM_INVALID("0102", "无效的参数"),
    RET_PARAM_TOO_LARGE_LIST("0103", "列表超长"),
    RET_PARAM_TYPE_INVALID("0104", "参数类型错误"),
    RET_CURRENT_PAGE_INVALID("0105", "当前页码非法"),
    RET_VIEW_NUMBER_INVALID("0106", "分页显示数目非法"),
    RET_VIEW_LIMIT_INVALID("0107", "数据排列显示数目非法"),

    //  失败(02开始标示DB操作相关错误码)
    RET_DB_FAIL("0201", "数据库操作失败"),

    //  失败(03开始标示权限相关错误码)
    RET_AUTH_NO_LOGIN("0301", "未登录"),
    RET_AUTH_NO_ACCESS_RIGHTS("0302", "无访问权限"),

    // 业务相关
    RET_BIZ_DATA_NOT_EXISTS("1001", "数据不存在"),
    RET_BIZ_SING_DATA_FAIL("1002", "商户签名数据不正确"),
    RET_BIZ_WX_PAY_CREATE_FAIL("1003", "微信支付下单失败"),
    RET_BIZ_ALI_PAY_CREATE_FAIL("1004", "支付宝支付下单失败"),



    RET_BIZ_PAY_NOTIFY_VERIFY_FAIL("1005", "支付通知数据验证不正确"),

    RET_BIZ_XY_CREATE_FAIL("1006", "星云支付下单失败"),

    RET_BIZ_XY_QUERY_FAIL("1006", "星云支付查询支付失败"),

    RET_BIZ_HELI_CREATE_FAIL("1007", "heli支付下单失败"),

    RET_BIZ_ORDER_NOTICE_FAIL("1008", "补发通知失败"),

    RET_SETTLEMENT_ALI_FAIL("1009", "提现支付宝失败"),

    RET_SETTLEMENT_BANK_FAIL("1010", "提现银行上游失败"),

    RET_SETTLEMENT_BANK_DECRYPT_FAIL("1011", "银行回调解密失败"),


    RET_SETTLEMENT_BANK_QUERY_FAIL("1012", "提现银行查询失败"),

    RET_BIZ_CLOUD_CREATE_FAIL("1013", "云闪付支付下单失败"),



    RET_BIZ_WX_CREATE_FAIL("1014", "微信支付下单失败"),


    RET_BIZ_TIAN_YU_PAY_CREATE_FAIL("1015", "tian yu 支付下单失败"),
    RET_BIZ_TIAN_YU_PAY_QUERY_FAIL("1016", "tian yu 支付查询失败"),

    RET_BIZ_MQZF_QUERY_FAIL("1007", "MQZF支付下单失败"),



    RET_BIZ_ALI_QRCODE_PAY_CREATE_FAIL("1018", "支付宝 qrcode 下单失败"),


    RET_SETTLEMENT_ALI_QUERY_FAIL("1019", "支付宝提现订单查询失败"),

    RET_BIZ_WAY_WAY_PAY_CREATE_FAIL("1015", "tian yu 支付下单失败"),
    RET_BIZ_WAY_WAY_PAY_QUERY_FAIL("1016", "tian yu 支付查询失败"),
    RET_BIZ_CHARGE_CREATE_FAIL("1020", "Charge支付下单失败"),

    RET_BIZ_CHARGE_QUERY_FAIL("1021", "Charge支付查询订单失败"),

    RET_BIZ_CHARGE_NOTIFY_FAIL("1022", "Charge支付回调订单解密失败"),


    RET_BIZ_EASY_CREATE_FAIL("1023", "E 支付 下单失败"),

    RET_BIZ_EASY_QUERY_FAIL("1024", "E 支付 支付查询订单失败"),

    RET_BIZ_TYIK_CREATE_FAIL("1025", "TYIK支付下单失败"),

    RET_BIZ_TYIK_QUERY_FAIL("1025", "TYIK支付下单失败"),

    RET_BIZ_PDD_CREATE_FAIL("1025", "PDD 支付下单失败"),

    RET_BIZ_PDD_QUERY_FAIL("1025", "PDD 支付查询订单失败"),


    RET_BIZ_MOBILE_CREATE_FAIL("1025", "mobile 支付下单失败"),

    RET_BIZ_MOBILE_QUERY_FAIL("1025", "mobile 支付查询订单失败"),

    // 未知错误
    RET_UNKNOWN_ERROR("9999", "未知错误");


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
