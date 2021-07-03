package cn.itcast.Demo16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;
/*
模拟B-S通信(浏览器-服务器),这里的服务器依然采用Tcp服务器
开启服务器,浏览器发出请求,服务器获取浏览器请求信息,并截取得到浏览器需要访问的路径字符串,根据路径去本都读取数据再通过网络字节输入流返回给浏览器显示
浏览器是每读取一次服务器数据就发一个请求(如果一个网页有很多个图片,就需要请求很多次,浏览器是多线程的,可以同时请求),因此服务器需要保持监听状态并开启多线程应对

重点
BufferedReader br = new BufferedReader(new InputStreamReader(is));
从记事本或者pdf中复制来的内容最好自己在idea中手敲出来(不然可能因为编码格式导致程序报错)
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);//开启服务,不关闭

       while (true){
           Socket socket = ss.accept();//获取浏览器请求对象(一直循环等待获取)

           new Thread(new Runnable() {
                 @Override
               public void run() {//注意:Runnable子类重写父类方法,父类的方法没有抛出异常,子类也不能抛出,只能tryCatch
                   try {

                       //1.获取浏览器请求路径
                       InputStream is = socket.getInputStream();
                       //把网络字节输入流对象转换成字符缓冲输入流(就可以用readLine方法读取第一行)
                       BufferedReader br = new BufferedReader(new InputStreamReader(is));
                       //获取浏览器请求信息并截取得到第一行(GET /one/web/index.html HTTP/1.1),再根据空格切割(看见空格切一刀,分成若干个字符串),返回值一个字符串数组
                       String[] str = br.readLine().split(" ");
                       //只要数组中第二个字符串(并且使用subString字符串切割(开始位置,结束位置),从索引1到最后都要,就0不要)one\\web\\index.html
                       String str2 = str[1].substring(1);

                       //3.读取路径下的数据并返回
                       FileInputStream fis = new FileInputStream(str2);
                       OutputStream os = socket.getOutputStream();

                       // 2.此处写入HTTP协议响应头,固定写法
                       os.write("HTTP/1.1 200 OK\r\n".getBytes());
                       os.write("Content-Type:text/html\r\n".getBytes());
                       // 必须要写入空行,否则浏览器不解析
                       os.write("\r\n".getBytes());

                       //3.读取路径下的数据并返回
                       int len=0;
                       byte[] bytes = new byte[1024];
                       while ((len=fis.read(bytes))!=-1){//根据截取到的路径字符串读取数据,再通过网络字节输入流返回给浏览器
                           os.write(bytes,0,len);//记住写入数据一定要指定数组开始和结束位置
                       }
                       //注意一般关闭流,需要关闭服务器或者客户端的流,以及获取到的请求对象的流,还需要关闭new出来的流(如果成为了其他流的参数则只需要关闭主要的那个流即可)
                       fis.close();
                       socket.close();
                   }catch (IOException e){
                       e.printStackTrace();
                   }
               }
           }).start();

       }
       //ss.close();服务器保持监听状态,不关闭


    }

}

