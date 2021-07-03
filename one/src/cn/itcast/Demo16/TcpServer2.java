package cn.itcast.Demo16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TcpServer2 {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket,和系统要指定的端口号
        ServerSocket server = new ServerSocket(8080);

        Socket socket = server.accept();
        InputStream is = socket.getInputStream();

        int len;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }
}


//开启服务器,浏览器输入http://127.0.0.1:8080/one/web/index.html,即浏览器要访问服务器,发出了一个请求,服务器获取到的请求数据如下:
//GET /one/web/index.html HTTP/1.1
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//Accept-Language: zh-CN
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763
//Accept-Encoding: gzip, deflate
//Host: 127.0.0.1:8080
//Connection: Keep-Alive