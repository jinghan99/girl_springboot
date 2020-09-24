package com.yf.m3u8.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.yf.m3u8.vo.M3u8TsVo;
import com.yf.m3u8.vo.M3u8Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @Package com.yf.m3u8.utils
 * @Description: TODO
 * @author: jingh
 * @date 2020/8/29 17:16
 */
public class M3u8TestUtils {

    private static final Logger logger = LoggerFactory.getLogger(M3u8TestUtils.class);

    /**
     * 下载文件名称
     */
    public static final String FILE_NAME = "元龙12集";

    /**
     * 文件夹地址
     */
    public static final String DOWNLOAD_DIR = "d:\\Users\\jingh\\Desktop";

    /**
     * 缓存文件夹
     */
    public static final String TEMP_DIR= "temp";

    public static final int connTimeout = 30 * 60 * 1000;

    public static final int readTimeout = 30 * 60 * 1000;


    public static void main(String[] args) {
        String m3u8Url = "https://douban.donghongzuida.com/20200905/8997_c8f1bc37/index.m3u8";


        String downloadFileDir = DOWNLOAD_DIR + File.separator + FILE_NAME;

        String tempDir = DOWNLOAD_DIR + File.separator + FILE_NAME + File.separator + TEMP_DIR;

        File file = new File(downloadFileDir);
        if (!file.exists()) {
            file.mkdirs();
        }

        boolean flag = m3u8Download(m3u8Url,tempDir);
        if (!flag) return;
        File tempDIr = new File(tempDir);
        if(tempDIr.isDirectory()){
            File[] fileTemps = tempDIr.listFiles();
            if(ObjectUtil.isNotEmpty(fileTemps)){
                Arrays.sort(fileTemps);
                List fileList = Arrays.asList(fileTemps);
                mergeFiles(fileList, downloadFileDir + File.separator + FILE_NAME+".mp4");
            }
        }
    }

    private static boolean m3u8Download(String m3u8Url,String tempDir) {
        M3u8Vo m3u8ByURL = retryM3U8ByURL(m3u8Url);
        if (m3u8ByURL == null) {
            logger.info("retryM3U8ByURL 失败");
            return false;
        }
        String basePath = m3u8ByURL.getBasepath();
        logger.info("basePath 链接{}", basePath);
//        创建缓存文件夹
        File tempDIr = new File(tempDir);
        if (!tempDIr.exists()) {
            tempDIr.mkdirs();
        }

        m3u8ByURL.getTsList().stream().parallel().forEach(m3U8Ts -> {
            String ts = m3U8Ts.getLineIndex() + ".ts";
            File file = new File(tempDir + File.separator + ts);
            if (!file.exists()) {// 下载过的就不管了
                FileOutputStream fos = null;
                InputStream inputStream = null;
                try {
                    logger.info("下载切片链接{}", m3U8Ts.getFile());
                    //链式构建请求
                    HttpResponse execute = HttpRequest.get(m3U8Ts.getFile())
                            .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                            .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1 Edg/85.0.4183.83")
                            //超时，毫秒
                            .setReadTimeout(readTimeout)
                            //超时，毫秒
                            .setConnectionTimeout(connTimeout)
                            .execute();
                    if (execute.isOk()) {
                        inputStream = execute.bodyStream();
                        fos = new FileOutputStream(file);// 会自动创建文件
                        int len = 0;
                        byte[] buf = new byte[1024];
                        while ((len = inputStream.read(buf)) != -1) {
                            fos.write(buf, 0, len);// 写入流中
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {// 关流
                    try {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("文件下载完毕!");
        return true;
    }

    public static M3u8Vo retryM3U8ByURL(String m3u8URL) {
        int retry = 3;
        for (int i = 0; i < retry; i++) {
            try {
                M3u8Vo m3U8ByURL = getM3U8ByURL(m3u8URL);
                if (m3U8ByURL != null) {
                    if (StrUtil.isNotEmpty(m3U8ByURL.getNextUrl())) {
                        m3u8URL = m3U8ByURL.getNextUrl();
//                        进入下次循环
                        continue;
                    }
                    if (ObjectUtil.isNotEmpty(m3U8ByURL.getTsList())) {
                        return m3U8ByURL;
                    }
                }
            } catch (Exception e) {
                logger.error("重试M3u8Vo", e);
            }
        }
        return null;
    }

    /**
     * 返回m3u8 切片 ts数据
     *
     * @param m3u8URL
     * @return
     */
    public static M3u8Vo getM3U8ByURL(String m3u8URL) {
        try {
            HttpResponse execute = HttpRequest.get(m3u8URL)
                    .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header(Header.USER_AGENT, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1 Edg/85.0.4183.83")
                    .setReadTimeout(readTimeout)//超时，毫秒
                    .setConnectionTimeout(connTimeout)//超时，毫秒
                    .execute();
            if (execute.isOk()) {
                URL url = URLUtil.url(m3u8URL);
                BufferedReader reader = new BufferedReader(new InputStreamReader(execute.bodyStream()));
                M3u8Vo m3u8Vo = new M3u8Vo();
                String basePath = m3u8URL.replace(url.getPath(), "");
                m3u8Vo.setBasepath(basePath);
                String lineText;
                int mIndex;
                int lineIndex = 100000;
                while ((lineText = reader.readLine()) != null) {
                    logger.info("m3u8信息{}", lineText);
                    if (lineText.startsWith("#")) {
                        if (lineText.startsWith("#EXTINF:")) {
                            lineText = lineText.substring(8);
                            if ((mIndex = lineText.indexOf(",")) != -1) {
                                lineText = lineText.substring(0, mIndex + 1);
                            }
                        }
                        continue;
                    } else if (lineText.endsWith(".ts")) {
                        lineIndex = lineIndex + 1;
                        if (lineText.startsWith("/")) {
                            m3u8Vo.addTs(new M3u8TsVo(basePath + lineText, lineIndex));
                        } else {
                            // 同层级url
                            String localPathUrl = m3u8URL.substring(0, m3u8URL.lastIndexOf("/"));
                            m3u8Vo.addTs(new M3u8TsVo(localPathUrl + "/" + lineText, lineIndex));
                        }
                    } else {
                        String nextUrl = basePath + lineText;
                        // 重定向到 同层级url
                        if (!lineText.startsWith("/")) {
                            //  同层级 url
                            String pathUrl = m3u8URL.substring(0, m3u8URL.lastIndexOf("/"));
                            nextUrl = pathUrl + "/" + lineText;
                        }
                        m3u8Vo.setNextUrl(nextUrl);
                        return m3u8Vo;
                    }
                }
                reader.close();
                return m3u8Vo;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean mergeFiles(List<File> temps, String resultPath) {
        if (temps == null || temps.size() < 1) {
            return false;
        }

        if (temps.size() == 1) {
            return temps.get(0).renameTo(new File(resultPath));
        }
        for (int i = 0; i < temps.size(); i++) {
            if (!temps.get(i).exists() || !temps.get(i).isFile()) {
                return false;
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(resultPath);
            byte[] b = new byte[4096];
            for (File f : temps) {
                if(f.isFile()){
                    FileInputStream fileInputStream = new FileInputStream(f);
                    int len;
                    while ((len = fileInputStream.read(b)) != -1) {
                        fileOutputStream.write(b, 0, len);
                    }
                    fileInputStream.close();
                    fileOutputStream.flush();
                }
            }
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

         for (int i = 0; i < temps.size(); i++) {
             temps.get(i).delete();
         }

        return true;
    }
}
