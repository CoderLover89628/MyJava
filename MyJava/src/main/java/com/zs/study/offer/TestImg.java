package com.zs.study.offer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2017-02-15 11:31
 * @class com.zs.study.offer.TestImg
 * @see
 */
public class TestImg {

    public static void main(String[] args)
    {
        byte[] imgBytes = new byte[1024 * 1024];

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream reader = null;
        InputStream in = null;
        URLConnection conn = null;
        File temFile = null;
        try{
//            File _file = new File("http://172.17.55.82/bdp-uploaded-files/201702151435-d5c9711a-a40c-4f76-923d-9329bda0a498.jpg?Expires=3634624204&AccessKey=6f4e945a1d556e6d87d9bf41c7cdfc3f11da2dc2&Signature=%2BRy7twzxeaCV%2F556rmRx6pK%2B2mA%3D"); //读入文件
//            Image src = javax.imageio.ImageIO.read(_file); //构造Image对象
//            int wideth=src.getWidth(null); //得到源图宽
//            int height=src.getHeight(null); //得到源图长
//            System.out.println(wideth+","+height);



            String strUrl = "http://172.17.55.82/bdp-uploaded-files/201702151435-d5c9711a-a40c-4f76-923d-9329bda0a498.jpg?Expires=3634624204&AccessKey=6f4e945a1d556e6d87d9bf41c7cdfc3f11da2dc2&Signature=%2BRy7twzxeaCV%2F556rmRx6pK%2B2mA%3D";
//            BufferedInputStream bis = null;
//            HttpURLConnection urlconnection = null;
//            URL url = new URL(strUrl);
//            urlconnection = (HttpURLConnection) url.openConnection();
//            urlconnection.connect();
//            bis = new BufferedInputStream(urlconnection.getInputStream());
//            System.out.println("file type:"+HttpURLConnection.guessContentTypeFromStream(bis));
//
            URL imgUrl = new URL(strUrl);
            conn = imgUrl.openConnection();
            temFile = new File("Chrysanthemum.jpg");
            FileOutputStream tem = new FileOutputStream(temFile);
            BufferedImage image = ImageIO.read(conn.getInputStream());
            ImageIO.write(image, "jpg", tem);
            in = new FileInputStream(temFile);
            reader = new BufferedInputStream(in);
            byte[] buffer = new byte[1024];
            while(reader.read(buffer) != -1){
                out.write(buffer);
            }
            imgBytes = out.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(temFile != null){
                temFile.delete();
            }
        }
        System.out.println("imgBytes is:" + imgBytes);
        try {
            File _file = new File(imgBytes.toString()); //读入文件
            Image src = ImageIO.read(_file); //构造Image对象
            int wideth=src.getWidth(null); //得到源图宽
            int height=src.getHeight(null); //得到源图长
            System.out.println(wideth+","+height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
