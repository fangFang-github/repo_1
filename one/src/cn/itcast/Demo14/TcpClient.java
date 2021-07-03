package cn.itcast.Demo14;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

//从服务器下载数据到本地
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        File file = new File("C:\\bbb");
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file + "\\b.jpg");
        int len;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        System.out.println("下载完毕");//不用返回给服务器
//        socket.getOutputStream().write("下载完毕".getBytes());
        socket.close();
        fos.close();
    }
}
