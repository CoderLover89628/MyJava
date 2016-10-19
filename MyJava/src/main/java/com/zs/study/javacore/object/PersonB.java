package com.zs.study.javacore.object;

/**
 * @author zhangsheng1
 * @version V1.0.0
 * @description
 * @date 2016-09-08 18:09
 * @last-modifier
 * @last-modified
 * @class com.zs.study.javacore.object.PersonB
 * @see
 */
public class PersonB {
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
        PersonA person = new PersonA();
        person.setName(null);
        PersonB personB = new PersonB();
        personB.setName(person.getName());

        String para = "abcdef";
        String[] param = para.split(",");
        for (int i = 0,len = param.length; i < len; i++) {
            System.out.println("i is:" + param[i]);
        }
        System.out.println(param.length);
        String[] ss = {"a","b","c","d"};
        for (String s : ss) {
            if ("c".equals(s)){
                return;
            }
            System.out.println("s is:" + s);
        }
    }
}
