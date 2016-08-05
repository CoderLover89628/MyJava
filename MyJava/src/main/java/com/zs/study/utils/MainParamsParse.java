package com.zs.study.utils;

import org.apache.commons.cli.*;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by zhangsheng1 on 2016/8/5.
 * 解析主函数传参
 *
 */
public class MainParamsParse {

    private String[] args;
    private int id;
    private String username;
    private int age;
    private int gender;
    private boolean isAuth;
    private String[] departments;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public boolean isAuth()
    {
        return isAuth;
    }

    public void setAuth(boolean auth)
    {
        isAuth = auth;
    }

    public String[] getDepartments()
    {
        return departments;
    }

    public void setDepartments(String[] departments)
    {
        this.departments = departments;
    }

    private static Properties properties = new Properties();

    public MainParamsParse(String... args) {
        this.args = args;
    }

    public MainParamsParse invoke() {
        CommandLineParser lineParser = new PosixParser();
        Options options = buildOptions();
        CommandLine cmd = null;
        try {
            cmd = lineParser.parse(options, args);
            setParams(cmd);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return  this;
    }

    private void setParams(CommandLine cmd){
        if(cmd != null){
            if(cmd.hasOption("P")){// -P:代表要执行的properties文件
                String propertiesFile = cmd.getOptionValue("P");
                properties = PropertiesUtil.loadProperties(propertiesFile);
            }
            if(cmd.hasOption("e")){//读取输入参数
                try {
                    Properties extendProperties = cmd.getOptionProperties("e");
                    Enumeration en = extendProperties.propertyNames();

                    while (en.hasMoreElements()) {// 批量修改如 -e id=100 -e age=25这样的
                        String key = en.nextElement().toString();//key值
                        System.out.println("old " + key + "=" + properties.get(key));
                        properties.put(key, extendProperties.get(key));
                        System.out.println("extend " + key + "=" + properties.get(key));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        /**
         * 设置参数
         */
        username = properties.getProperty(Const.USER_NAME);
        isAuth = Boolean.parseBoolean(properties.getProperty(Const.HAS_AUTH));
        id = Integer.parseInt(properties.getProperty(Const.ID));
        age = Integer.parseInt(properties.getProperty(Const.AGE));
        gender = Integer.parseInt(properties.getProperty(Const.GENDER));

        try {
            byte[] preDepart = properties.getProperty(Const.DEPART_MENT).getBytes("ISO-8859-1");
            String ss = new String(preDepart,"gbk");
            departments = ss.split(",");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * -p为配置文件，-e为配置参数
     * @return
     */
    private static Options buildOptions() {
        Options options = new Options();
        options.addOption("P", true, "external load properties filename");
        options.addOption("libjars", true, "extend jar");
        options.addOption(OptionBuilder
                .withArgName("property=value")
                .hasArgs(2)
                .withValueSeparator()
                .withDescription("extend info for defalut load properties ").create("e"));

        options.addOption(OptionBuilder
                .withArgName("property=value")
                .hasArgs(2)
                .withValueSeparator()
                .withDescription("my info for defalut load properties ").create("m"));

        return options;
    }
}
