package cn.itcast.Demo12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
TCP协议需要先开启服务器端,等待客户端发来请求,服务器处理请求再回写数据
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket so = new Socket("127.0.0.1", 8888);

        OutputStream os = so.getOutputStream();
        os.write("你好服务器".getBytes());//需要将字符串转为字节,(字节输出流对象传输的是字节)

        InputStream is = so.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        len=is.read(bytes);//一次就能读取完,不需要循环读取(len是数组的长度)
        System.out.println(new String(bytes,0,len));//需要将字节数组转换成字符串打印
        so.close();//关闭流
    }
}
