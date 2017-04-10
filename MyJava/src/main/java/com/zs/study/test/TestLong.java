package com.zs.study.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2017-03-28 9:42
 * @class com.zs.study.test.TestLong
 * @see
 */
public class TestLong {
    public static void main(String[] args)
    {
        Long time = System.currentTimeMillis();
        long time2 = 3600 * 1000 ;
        long time3 = 24 * 30;
        System.out.println("time2 is:" + time2);
        System.out.println("time3 is:" + time3);
        Long addTime = time + time2 * time3;
        System.out.println(time);
        System.out.println("===========");
        System.out.println(addTime);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        String timer = dateFormat.format(calendar.getTime());
        System.out.println("timer is:" + timer);
    }
}
