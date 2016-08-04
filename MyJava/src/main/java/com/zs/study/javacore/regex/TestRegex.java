package com.zs.study.javacore.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangsheng1 on 2016/7/26.
 * 正则
 */
public class TestRegex {
    public static void main(String[] args)
    {
        String msg = "a_1";
        if (isLowCharFirst(msg)) {
            System.out.println(msg + " is great");
        } else {
            System.out.println(msg + " is wrong");
        }
    }

    private static boolean isLowCharFirst(String str) {
        String regex = "^[a-z][a-z0-9_]*$";// 以小写字母开头，可以包含小写字母，数字和下划线的字符串
        return match(regex,str);
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
