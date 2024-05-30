package com.example.widely_known.utils;

import java.util.UUID;

/**
* <p>
    * Id生成工具类
    * </p>
*
* @author  
* @since 2024-05-22
*/
public class IdUtils
{
    /**
     * 获取随机UUID
     * 
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return randomUUID().replace("-","");
    }
    public static String simpleUUID(int length){
        String s = simpleUUID();
        return s.length()>length?s.substring(0,length):s;
    }

}