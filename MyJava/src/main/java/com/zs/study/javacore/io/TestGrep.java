package com.zs.study.javacore.io;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2016-10-25 18:03
 * @class com.zs.study.javacore.io.TestGrep
 * @see
 */
public class TestGrep {
    public static void main(String[] args)
    {
        // 创建一个文件
        // 为增加可移植性，建议使用File.separator
        File file = new File("e:" + File.separator + "我的文档" + File.separator + "Test" + File.separator + "text.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("创建文件失败,失败原因:" + e.getMessage());
        }

        // 删除一个指定文件
        if (file.exists()) {
            System.out.println("指定文件存在,执行删除.....");
            file.delete();
        } else {
            System.out.println("指定文件不存在，不执行删除......");
        }

        // 创建目录
        File f = new File("e:" + File.separator + "我的文档" + File.separator + "Test" + File.separator + "新建文件夹");
        // 以下两个都是创建，但是区别是mkdirs的路径长度没有限制,而mkdir有限制
        f.mkdir();
        f.mkdirs();

        // 列出指定目录的全部文件

    }
}
