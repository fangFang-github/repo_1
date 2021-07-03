package cn.itcast.Demo13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
注意:从客户端或者服务器下载的文件不能放在根目录中,必须放在文件夹中
(要先判断文件夹是否存在,不存在要先创建,字节输入流不会创建文件夹(会自动创建文件再输出数据到文件中))
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);//服务器的socket对象,本身没有IO流要借助客户端的socket获取
        Socket so = ss.accept();//获取到请求的客户端对象socket
        InputStream is = so.getInputStream();//网络输入流读取客户端文件

        File file = new File("C:\\aaa");
        if(!file.exists()){//如果文件不存在则创建一个
            file.mkdirs();//创建文件夹
        }
        /*
//        FileOutputStream fos = new FileOutputStream("C:\\aaa.jpg");
        FileOutputStream fos = new FileOutputStream(file + "\\aaa.jpg");*/
        FileOutputStream fos = new FileOutputStream(file+"\\aaa.jpg");

        int len;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){//此处会接收到一个客户端socket上传的结束标记,程序不会阻塞
            fos.write(bytes,0,len);//字节输出流将客户端文件保存到本地
        }

        OutputStream os = so.getOutputStream();//网络输出流对客户端数据回写
        os.write("收到文件并保存".getBytes());
        ss.close();
        fos.close();
        so.close();



    }


}
