package com.zs.study.javacore.object;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description
 * @date 2016-09-08 18:08
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.object.PersonA
 * @see
 */
public class PersonA {
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static void main(String[] args)
    {
        Map<String,String> names = new HashMap<String, String>();
        names.put("hello","world");
        names.put("hello","worlds");
        System.out.println(names.get("hello"));
        String name = "hello(zhangsheng)";
        System.out.println("subName is:" + name.substring(name.indexOf("(") + 1,name.indexOf(")")));

        String namea = name.contains("{") ? name.substring(0,name.indexOf("{")) : name;
        System.out.println("subName isssss: " + namea);

        int groupId=10159;
        String url = "http://test.bdp.jd.com/jsd/appgroup/v2/edit.html?appgroupId=";
        url = url + groupId;
        String msg = "<a href='"+url+"' id='appGroupCode_edit' target='_Blank'>" + "点击此处" + "</a>";
        System.out.println("msg is:" + msg);
    }
}
