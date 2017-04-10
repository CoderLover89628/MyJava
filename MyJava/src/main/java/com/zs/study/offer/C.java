package com.zs.study.offer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2017-01-13 11:14
 * @class com.zs.study.offer.C
 * @see
 */
public class C {
    public static void main(String[] args)
    {
//        new B().soutMsg();
        Set<String> cSet = new HashSet<String>();
        cSet.add("zhangsan");
        cSet.add("lisi");
        cSet.add("wangmazi");
        cSet.remove("lisi2");
        Iterator<String> it = cSet.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("value is:" + value);
        }


        String msg = "A_B_C";
        String[] value = msg.split("_");
        for (String val : value) {
            System.out.println("value is :" + val);
        }

        Set<String> sss = new HashSet<String>();
        sss.add("s");
        if (1== 1) {
            boolean flg = sss.add("s");
            if (flg) {
                System.out.println("success");
            } else {
                System.out.println("failure");
            }
        }

        String ssss  = ",zhangshan";
        String result = ssss.substring(ssss.indexOf(",") + 1);
        System.out.println("result is :" +result);


        String a = "lisi";
        String b = "zhangsan,lisi,";
        if (b.contains(a)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
