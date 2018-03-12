package com.yf.utils;


import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ReadProperties
 * @Description
 * @Date 2018/3/6 17:52
 * @Author jinghan
 * @Version 1.0
 */
public class ReadProperties {

    private static Logger logger = Logger.getLogger(ReadProperties.class);

    public static String driverClassName = null;
    public static String url = null;
    public static String username = null;
    public static String password = null;
    public static String fileUrl = null;
    public static String textEncoding = null;

    //类加载后就执行,在需要的地方直接用类名.属性名即可，如ReadProperties.host，其他类要使用时需要将属性定义成public的，或者提供get方法
    static{
        loads();
    }

    /**
     * 读取properties
     */
    public static void loads(){
        if(driverClassName == null || fileUrl == null)
        {
            InputStream is = ReadProperties.class.getResourceAsStream("/dbconfig.properties");
            Properties dbProps = new Properties();
            try {
                dbProps.load(is);
                driverClassName = dbProps.getProperty("jdbc.driverClassName");
                url = dbProps.getProperty("jdbc.url");
                username = dbProps.getProperty("jdbc.username");
                password = dbProps.getProperty("jdbc.password");
                fileUrl = dbProps.getProperty("fileUrl");
                textEncoding = dbProps.getProperty("textEncoding");
            }catch (Exception e) {
                logger.error("不能读取属性文件. \" +\"请确保dbconfig.properties在CLASSPATH指定的路径中",e);
            }
        }
    }

    /**
     * 也可以调方法获取值，这样更万无一失,强烈建议用此方法，防止jvm内存回收后数据为空（看网上说静态属性是不会被回收的，除非类被回收）
     * @return
     */
    public static String getDriverClassName() {
        if(driverClassName==null){
            loads();
        }
        return driverClassName;
    }

    public static String getUrl() {
        if(url == null){
            loads();
        }
        return url;
    }

    public static String getUsername() {
        if(driverClassName==null){
            loads();
        }
        return username;
    }

    public static String getPassword() {
        if(driverClassName==null){
            loads();
        }
        return password;
    }

    public static String getFileUrl() {
        if(fileUrl==null){
            loads();
        }
        return fileUrl;
    }
    public static String getTextEncoding(){
        if(fileUrl==null){
            loads();
        }
        return textEncoding;
    }
}
