package cn.itcast.Demo13;
//从客户端上传数据到服务器硬盘(本地)
import java.io.*;
import java.net.Socket;
/*
特别注意:但凡是字节输入输出流操作的都是字节,本文中操作的是字节数组,os.write(bytes,0,len);
读取可以用数组来装fis.read(bytes),但是从数组取出就得给起始结束位置os.write(bytes,0,len);
千万不能写成os.write(bytes),对字节数组的操作要给定起始和结束位置
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\20190410001852.jpg");
        Socket so = new Socket("127.0.0.1",8888);
        OutputStream os = so.getOutputStream();
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1){//字节输入流读取本地文件
            os.write(bytes,0,len);//使用网络字节输出流将文件上传到服务器
        }
        //需要给服务器上传一个结束标记
        so.shutdownOutput();//输出完毕
        InputStream is = so.getInputStream();//获取网络字节输入流
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //关闭流
        fis.close();
        so.close();


    }











}
