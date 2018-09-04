package com.yf.common.tts;

import com.squareup.okhttp.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

/**
 * @Package com.ljg.common.utils.http
 * @Description: TODO
 * @author: jingh
 * @date 2018/8/30 14:16
 */
public class xfyunTTS {

    /**
     * 科大讯飞语音识别写入参考
     * https://github.com/IflytekAIUI/DemoCode/blob/master/webapi/java/Iat.java
     */
    final static String APPID = "5b87b219", APPKEY = "9b65b4bc9af3dfad8649ba1be148684f";
    final static String url         = "http://api.xfyun.cn/v1/service/v1/TTS";

    public static void main(String[] args) throws IOException {

        tts("我是讯飞");
    }

    /**  讯飞 post
     * @param:
     * @return:
     * @auther: jingh
     * @date: 2018/8/31 9:46
     */
    public static byte[] tts(String text) throws IOException {
        Base64 base64 = new Base64();
        String param = "{\"auf\":\"audio/L16;rate=16000\",\"aue\":\"lame\",\"voice_name\":\"xiaoyan\",\"speed\":\"50\",\"volume\":\"80\",\"pitch\":\"50\",\"engine_type\":\"intp65\",\"text_type\":\"text\"}";
        String currentTimeMillis = System.currentTimeMillis() / 1000L + "";
        String paramBase64 = base64.encodeAsString(param.getBytes("UTF-8"));
        String md5Hex = DigestUtils.md5Hex((APPKEY + currentTimeMillis + paramBase64).getBytes());
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormEncodingBuilder()
                .add("text", text)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .header("X-CurTime", currentTimeMillis)
                .addHeader("X-Param", paramBase64)
                .addHeader("X-Appid", APPID)
                .addHeader("X-CheckSum", md5Hex)
                .addHeader("X-CurTime", currentTimeMillis)
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        byte[] bytes = response.body().bytes();

//

        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        return bytes;
    }

}
