package com.zs.study.offer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2017-02-28 11:59
 * @class com.zs.study.offer.TestDate
 * @see
 */
public class TestDate {

    public static void main(String[] args) throws Exception
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2017-02-28 10:10:10";
        Date date = simpleDateFormat.parse(time);
        if (date.before(new Date())) {
            System.out.println("yesterday");
        } else {
            System.out.println("now");
        }

        Calendar calendar = Calendar.getInstance();
        String value = convertTime(calendar.get(GregorianCalendar.HOUR_OF_DAY)) + ":" + convertTime(calendar.get(Calendar.MINUTE));
        System.out.println("value is:" + value);

        String refreshTime = convertTime(calendar.get(GregorianCalendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH)
                + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
        System.out.println("refreshTime is:" + refreshTime);


        boolean flg = false;
//        if (1==1) {flg = true;}
        if (1==1 && flg) {
            System.out.println("flg is false");
        } else {
            System.out.println("flg is true");
        }
    }

    private static String convertTime(int i)
    {
        return i < 10 ? "0" + i : i + "";
    }
}
