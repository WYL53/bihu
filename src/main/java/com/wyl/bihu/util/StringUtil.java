package com.wyl.bihu.util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/23.
 */
public class StringUtil {
    public static String generateUUID(int length){
        if(length > 32){
            length = 32;
        }
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
       return uuidString.replaceAll("-","").substring(0,length);
    }
}
