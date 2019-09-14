package com.zk.sell.utils;

import java.util.Random;

/**
 * @author ZhengKai
 * @data 2019-09-02 23:57
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
