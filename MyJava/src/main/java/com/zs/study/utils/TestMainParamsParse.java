package com.zs.study.utils;

/**
 * Created by zhangsheng1 on 2016/8/5.
 * test
 */
public class TestMainParamsParse {
    public static void main(String[] args)
    {
        MainParamsParse mainParamsParse = new MainParamsParse(args);
        mainParamsParse.invoke();
        System.out.println("the final message is:");
        System.out.println("id: " + mainParamsParse.getId() + ", userName: " + mainParamsParse.getUsername()
                + ", age: " + mainParamsParse.getAge() + ", gender: " + mainParamsParse.getGender());
        System.out.println(mainParamsParse.getDepartments().length);
    }
}
