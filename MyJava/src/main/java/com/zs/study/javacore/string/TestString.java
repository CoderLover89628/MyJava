package com.zs.study.javacore.string;


/**
 * Created by zhangsheng1 on 2016/7/15.
 *
 */
public class TestString {

    public static void main(String[] args)
    {
        String s = "hi,hello world!";
        System.out.println(getResult(s));
        StrReverseExample();
        StrReplaceExample();
        System.out.println(getParam(s,"hi","nice to meet U"));
        String ss = "zhangsh,kuaile,";
        System.out.println(ss.substring(0,ss.lastIndexOf(",")));

        String msg = "DML_mysql_2037,dml_sqlserver_2315,dmls_putaway,dml_mysql_2202,dmls_ob_shipment,DML_mysql_2021,tra_log_sqlserver_2268,dml_mysql_2230,dmls_peking,DML_mysql_2031,dml_mysql_2279,DML_sqlserver_2036,dmls_cals_jd_shenyang,dmls_test,bdp_urm_mail_content,dml_mysql_2206,dmls_ogg_monitor,DML_mysql_2025,transaction_log_ms_afs,app_jd_knowledge_graph_word_dict_all_w,dml_mysql_2274,DML_mysql_2035,dml_sqlserver_2268,dmls_product,dml_mysql_2201,dmls_ms_afs,DML_mysql_2020,tra_log_sqlserver_2243,dml_mysql_2229,dmls_ogg_waybill,DML_mysql_2030,transaction_log_test,dml_mysql_2278,DML_mysql_2085,dmls_ams_crm,dmls_stock,dml_mysql_2205,dmls_ogg_dms,dmls_poporder,DML_mysql_2024,transaction_log_jd2008,dml_mysql_2271,DML_mysql_2034,dml_sqlserver_2243,checkpoint_record,dmls_mobile_app,magpie_eggs_busi_stat,dml_mysql_2227,dmls_ogg_tms,DML_mysql_2029,transaction_log_product,dml_mysql_2277,DML_mysql_2067,dmls_afs_history,dmls_spsales,dml_mysql_2204,dmls_ogg_bd_thirdparty,dmls_peking_tc,DML_mysql_2023,transaction_log_cals_jd_shenyang,dml_mys,ddd";
        System.out.println("msg is: " + msg);

        String msssg = " , ";
        System.out.println(msssg.trim().split(",").length);
        for (String s1 : msssg.trim().split(",")) {
            System.out.println("hello");
        }
    }

    /**
     *  变参
     * @param params 变参相当于是数组
     * @return 参数组合
     */
    private static String getParam(String... params) {
        return params[0];
    }
    /**
     *  字符串反转之一
     * @param msg 字符串
     * @return 反转之后的字符串
     */
    private static String getResult(String msg)
    {
        if(msg == null || msg.length() == 0)
            return "";
        return getResult(msg.substring(1)) + msg.charAt(0);
    }

    /**
     * 字符串反转之二
     */
    private static void StrReverseExample() {
        String string = "abcdef";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("String before reverse:" + string);
        System.out.println("String after reverse:" + reverse);
    }

    /**
     * 字符串置换
     */
    private static void StrReplaceExample() {
        String msg = "crazyBoy（cb880），hello（h7385）";
        System.out.println(msg);
        msg = msg.replaceAll("d","(");
        msg = msg.replaceAll("f",")");
        System.out.println(msg);
    }

}
