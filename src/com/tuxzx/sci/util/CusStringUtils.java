package com.tuxzx.sci.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CusStringUtils {
    /**
     * 去除字符串中的空格
     * @param s
     * @return
     */
    public static String trimSpace (String s) {
        Pattern pattern = Pattern.compile("[\\s]");
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("");
    }
}
