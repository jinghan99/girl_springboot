package com.yf.common.nimwebserver;

import com.yf.common.constant.BizConstant;
import com.yf.common.utils.JSONUtils;
import com.yf.common.utils.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Date 2018/2/5 15:05
 * @Author jinghan
 * @Version 1.0
 */
public class NimUtils {


    /**
     * 获取云信token
     * @param accId
     * @param userNick
     * @return
     * @throws IOException
     */
    public static String getNimToken(String accId, String userNick) throws IOException {
        Map map = createUser(accId, userNick);
        String code = map.get("code").toString();
        //创建成功
        if (code.trim().equals("200")) {
            JSONObject infoMap = (JSONObject) map.get("info");
            return infoMap.get("token").toString();
        }
        //已注册 刷新获取新的 token
        if (code.trim().equals("414")) {
            map = NimUtils.refreshToken(accId);
            code = map.get("code").toString();
            if (code.trim().equals("200")) {
                JSONObject infoMap = (JSONObject) map.get("info");
                //更新
                update(accId,userNick);
                return infoMap.get("token").toString();
            }
        }
        return null;
    }


    /**
     * 保存新用户
     *
     * @param accId
     * @param userNick
     * @return
     * @throws IOException
     */
    private static Map createUser(String accId, String userNick) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BizConstant.NIM_CreateUrl.getValue());

        String nonce = String.valueOf(Utils.random(6));
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(BizConstant.NIM_AppSecret.getValue(), nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", BizConstant.NIM_AppKey.getValue());
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accId));
        nvps.add(new BasicNameValuePair("name", userNick));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        Map map = JSONUtils.jsonToMap(EntityUtils.toString(response.getEntity(), "utf-8"));
        System.out.println(map);
        httpClient.close();
        return map;
    }

    /**
     * 修改数据
     * @param accid
     * @param usernick
     * @return
     * @throws IOException
     */
    public static Map update(String accid, String usernick) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BizConstant.NIM_UpdateUrl.getValue());

        String nonce = String.valueOf(Utils.random(6));
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(BizConstant.NIM_AppSecret.getValue(), nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", BizConstant.NIM_AppKey.getValue());
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accid));
        nvps.add(new BasicNameValuePair("name", usernick));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        Map map = JSONUtils.jsonToMap(EntityUtils.toString(response.getEntity(), "utf-8"));
        System.out.println(map);
        httpClient.close();
        return map;
    }

    /**
     * 刷新token
     *
     * @Description
     * @Date 2018/2/5 18:10
     * @Author jinghan
     */
    public static Map refreshToken(String accid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BizConstant.NIM_RefreshTokenUrl.getValue());

        String nonce = String.valueOf(Utils.random(6));
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(BizConstant.NIM_AppSecret.getValue(), nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", BizConstant.NIM_AppKey.getValue());
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accid));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        Map map = JSONUtils.jsonToMap(EntityUtils.toString(response.getEntity(), "utf-8"));
        System.out.println(map);
        httpClient.close();
        return map;
    }

    /**
     * @Description nim加好友
     * @Date 2018/3/29 14:24
     * @Author jinghan
     * accid	String	是	加好友发起者accid
     * faccid	String	是	加好友接收者accid
     */
    public static Map friendAdd(String accid, String faccid) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(BizConstant.NIM_FriendAdd.getValue());

        String nonce = String.valueOf(Utils.random(6));
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(BizConstant.NIM_AppSecret.getValue(), nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", BizConstant.NIM_AppKey.getValue());
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accid));
        nvps.add(new BasicNameValuePair("faccid", faccid));
        nvps.add(new BasicNameValuePair("type", "1"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        System.out.println(response);
        Map map = JSONUtils.jsonToMap(EntityUtils.toString(response.getEntity(), "utf-8"));
        System.out.println(map);
        httpClient.close();
        return map;
    }


    public static void main(String[] args) {
        try {
            System.out.println(getNimToken("121312", "jinghan"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
