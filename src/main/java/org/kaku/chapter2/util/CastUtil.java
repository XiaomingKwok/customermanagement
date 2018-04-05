package org.kaku.chapter2.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: kaku
 * @Description:
 * @Date: Created on 4/1/18.
 */
public class CastUtil {

    public static String castString(Object obj){
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue){
        return obj!=null? String.valueOf(obj): defaultValue;
    }

    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue){
        double doubelValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    doubelValue = Double.parseDouble(strValue);
                }catch(NumberFormatException e){
                    doubelValue = defaultValue;
                }
            }
        }
        return  doubelValue;
    }

    public static long castLong(Object obj){
        return CastUtil.castLong(obj, 0);
    }

    public static long castLong(Object obj, long defaultValue){
        long longValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    public static int castInt(Object obj){
        return CastUtil.castInt(obj, 0);
    }

    public static int castInt(Object obj, int defaultValule){
        int intValue = defaultValule;
        if(obj != null){
            String strValue = CastUtil.castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue = defaultValule;
                }
            }
        }
        return intValue;
    }

    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defaultValue){
        boolean boolValue =  defaultValue;
        if(obj != null){
            String strValue = CastUtil.castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    boolValue = Boolean.parseBoolean(strValue);
                }catch (NumberFormatException e){
                    boolValue = defaultValue;
                }
            }
        }
        return boolValue;
    }

}
