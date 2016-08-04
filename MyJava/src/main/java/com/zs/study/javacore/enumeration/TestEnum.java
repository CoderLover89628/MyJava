package com.zs.study.javacore.enumeration;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Created by zhangsheng1 on 2016/8/4.
 *
 */
public enum TestEnum implements Serializable {
    TEST(1,"测试"),
    ONLINE(2,"线上")
            ;
    TestEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public static TestEnum enumValueOf(Integer code) {
        TestEnum v = null;
        for (TestEnum testEnum  : TestEnum.values()) {
            if (testEnum.getCode().equals(code)) {
                v = testEnum;
                break;
            }
        }

        return v;
    }

    public static TreeMap<Integer, String> toCodeDescriptionMap() {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        for (int i = 0; i < TestEnum.values().length; i++) {
            map.put(TestEnum.values()[i].getCode(), TestEnum.values()[i].getName());
        }
        return map;
    }

    public static void main(String[] args)
    {
        String name = TestEnum.enumValueOf(1).getName();
        System.out.println("name is :" + name);
    }
}
