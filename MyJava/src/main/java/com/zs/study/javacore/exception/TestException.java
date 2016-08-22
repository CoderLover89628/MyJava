package com.zs.study.javacore.exception;

/**
 * Created by zhangsheng1 on 2016/8/22.
 * 异常
 */
public class TestException {
    public static void main(String[] args)
    {
        try {
            String msg = getMesg();
            System.out.println("msg is:" + msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试当出现异常的时候，返回值问题
     * 结论：最后如果有return则不会抛出异常
     *       抛出异常则不会有返回值
     *
     *  引用：在spring的事物当中会用到，当出现异常的情况，进行事物的回滚
     *
     *
     * @return 返回值
     * @throws Exception
     */
    private static String getMesg() throws Exception {
        String a = "ddd";
        try {
            a = "hello";
            if (1 == 1) {
                throw new Exception("error");
            }
            return a;
        } catch (Exception e) {
            System.out.println("11111");
            return a;
//            throw new Exception("info");
        } finally {
            throw new Exception("info");
//            return a;
        }
    }
}
