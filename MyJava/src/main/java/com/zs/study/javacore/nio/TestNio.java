package com.zs.study.javacore.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangsheng1
 * @version V1.0.0
 *          Date 2016-10-28 10:30
 * @class com.zs.study.javacore.nio.TestNio
 * @see
 */
public class TestNio {
    public static void main(String[] args)
    {
        File file = new File("e:" + File.separator + "我的文档" + File.separator + "Test" + File.separator + "text.txt");

        if (file.exists())
            file.delete();

        createFile(file);
        appendWrite(file);
        /**
         * FileChannel 从文件中读写数据。

         DatagramChannel 能通过UDP读写网络中的数据。

         SocketChannel 能通过TCP读写网络中的数据。

         ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
         */
        testFileChannel(file);
    }

    /**
     * 向文件末尾追加内容
     * @param file file
     */
    private static void appendWrite(File file)
    {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file,"rw");

            // 获取文件的长度
            long fileLen = raf.length();
            raf.seek(fileLen);// 将位置定位到文件的末尾

            raf.writeBoolean(true);// 占1个字节
            raf.writeByte(0x41);// 占1个字节
            raf.writeChar('a');// 占1个字节
            raf.writeShort(0x3c3c); // 占2个字节
            raf.writeInt(0x75);     // 占4个字节
            raf.writeLong(0x1234567890123456L); // 占8个字节
            raf.writeFloat(4.7f);  // 占4个字节
            raf.writeDouble(8.256);// 占8个字节
            raf.writeUTF("UTF张"); // UTF-8格式写入
            raf.writeChar('\n');   // 占2个字符。“换行符”
            raf.writeChars("中华人民共和国\n");
            raf.write("中华人民共和国".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件创建
     * @param file file
     */
    private static void createFile(File file)
    {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file,"rw");
            raf.writeChars("abcdefghijklmnopqrstuvwxyz\n");
            raf.writeChars("0123456789\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * FileChannel 从文件中读写数据
     * @param file file
     */
    private static void testFileChannel(File file)
    {

        RandomAccessFile aFile = null;
        try {
            // RandomAccessFile中的model
            // ①"r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
            // ②"rw" 打开以便读取和写入。
            // ③"rws" 打开以便读取和写入。相对于 "rw"，"rws" 还要求对“文件的内容”或“元数据”的每个更新都同步写入到基础存储设备。
            // ④"rwd" 打开以便读取和写入，相对于 "rw"，"rwd" 还要求对“文件的内容”的每个更新都同步写入到基础存储设备。
            aFile = new RandomAccessFile(file.getAbsolutePath(),"r");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);// 每次读取的字符数
            int byteReads = inChannel.read(buf);
            while (byteReads != -1) {
                System.out.println("Read " + byteReads);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                byteReads = inChannel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                if (aFile != null)
                    aFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
