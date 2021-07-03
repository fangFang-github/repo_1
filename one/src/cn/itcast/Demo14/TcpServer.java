package cn.itcast.Demo14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        FileInputStream fis = new FileInputStream("F:\\a.jpg");
        Socket socket = ss.accept();
        OutputStream os = socket.getOutputStream();

        int len;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        socket.shutdownOutput();//给结束标记
        ss.close();
        socket.close();
        fis.close();



    }
}
