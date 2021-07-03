package cn.itcast.Demo15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//从客户端上传数据到服务器硬盘(本地),优化
public class TcpClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("F:\\a.jpg");
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
