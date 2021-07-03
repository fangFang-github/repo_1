package cn.itcast.Demo12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket so = ss.accept();//获取请求的客户端对象socket
        InputStream is = so.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        len=is.read(bytes);//读取客户端发来的数据,len是数组的长度
        System.out.println(new String(bytes,0,len));//使用字符串的构造方法将字节数组转换成字符串打印


        OutputStream os = so.getOutputStream();//给客户端回写数据
        os.write("收到,谢谢".getBytes());

        so.close();//服务器端需要关闭获取到的客户端对象还需要关闭自己服务器流对象
        ss.close();

    }
}
