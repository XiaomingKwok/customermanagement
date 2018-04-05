package org.kaku.chapter2.util;

/**
 * @Author: kaku
 * @Description:字符串工具类
 * @Date: Created on 4/1/18.
 */
public class StringUtil {

    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtil.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
