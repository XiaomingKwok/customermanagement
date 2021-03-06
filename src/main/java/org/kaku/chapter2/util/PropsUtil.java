package org.kaku.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @Author: kaku
 * @Description:属性文件工具类
 * @Date: Created on 4/1/18.
 */
public class PropsUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);

    /*
     *@Author: apple
     *@Description:加载属性文件
     *@Date: 12:12 PM 4/1/18
     *@Param:  * @param fileName
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName+"file is not found");
            }
            props = new Properties();
            props.load(is);
        }catch (IOException e){
            LOGGER.error("load properties file failed", e);
        }finally {
            if(is!= null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }
    /*
     *@Author: apple
     *@Description:
     *@Date: 12:14 PM 4/1/18
     *@Param:  * @param props
     * @param key
     */
    public static String getString(Properties props, String key){
        return getString(props, key, "");
    }


    public static String getString(Properties props, String key, String defaultValue){
        String value = defaultValue;
        if(props.contains(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties props, String key){
        return getInt(props, key, 0);
    }

    public static int getInt(Properties props, String key, int defaultValue){
        int value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    public static Boolean getBoolean(Properties props, String key){
        return getBoolean(props, key, false);
    }

    public static Boolean getBoolean(Properties props, String key, Boolean defaultValue){
        boolean value = defaultValue;
        if (props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }


}
