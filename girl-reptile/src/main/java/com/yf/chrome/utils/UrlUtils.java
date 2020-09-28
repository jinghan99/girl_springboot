package com.yf.chrome.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yf.chrome.handler.Bt51Handler;
import com.yf.chrome.utils.vo.UrlConvertVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jinghan
 * @title: ConversionLinkUtils
 * @projectName girl-springboot
 * @description: 链接工具
 * @date 2020/9/28 9:16
 */
public class UrlUtils {

    private static final Logger logger = LoggerFactory.getLogger(UrlUtils.class);

    public static void main(String[] args) {
        System.out.println(thunderConvert("thunder://QUFodHRwOi8vc3ZpcC5ib2NhaS16dWlkYS5jb20vMjAwOS/lhYPpvpktMTUubXA0Wlo="));;
    }
    /**
     * 链接转换
     * @return
     */
    public static String urlConvert(String convertUrl){
        String url = "https://tool.lu/urlconvert/ajax.html";
        String json = HttpRequest.post(url)
                .form("link",convertUrl)
                .header(Header.ACCEPT, "application/json, text/javascript, */*; q=0.01")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8")
                .header(Header.ORIGIN, "https://tool.lu")
                .header(Header.REFERER, "https://tool.lu/urlconvert/")
                .header("x-requested-with", "XMLHttpRequest")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                .execute().body();
        logger.info("链接转换 urlConvert {}",json);
        UrlConvertVo urlConvertVo = JSONUtil.toBean(json, UrlConvertVo.class);
        if(ObjectUtil.isNotEmpty(urlConvertVo.getText())){
            if(StrUtil.isNotEmpty(urlConvertVo.getText().getHttp())){
                return URLUtil.encode(urlConvertVo.getText().getHttp());
            }
        }
        return null;
    }

    /**
     *  迅雷thunder://地址与普通url地址转换
     *  其实迅雷的thunder://地址就是将普通url地址加前缀‘AA’、后缀‘ZZ’，再 base64编码 后得到的字符串
     * <p>Title: t1</p>
     * <p>Description: </p>
     * @param convertUrl
     * @return
     */
    public static String thunderConvert(String convertUrl){
        if(convertUrl.startsWith("thunder://")){
            convertUrl = convertUrl.substring(10);
            convertUrl= Base64.decodeStr(convertUrl);
            convertUrl =  convertUrl.substring(2, convertUrl.length()-2);
        }
        return convertUrl;
    }
}
