package com.zs.study.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zhangsheng1 on 2016/8/5.
 *
 */
public class PropertiesUtil {


    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        try {
//            FileInputStream propFile = new FileInputStream(fileName);
            properties.load(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName));

//            propFile.close();
        } catch (Exception e) {
            e.printStackTrace();

            InputStream inner = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            try {
                properties.load(inner);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return properties;
    }
}
