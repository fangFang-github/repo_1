package cn.itcast.Demo15;
/*
从客户端上传数据到服务器硬盘(本地)
优化:1.文件名写死导致有可能重名冲突会下载失败
优化:2.当客户端上传完成了,服务器回写数据之后,服务器就关闭了,不能再次传输
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);//服务器的socket对象,本身没有IO流要借助客户端的socket获取
        //为了让服务器一直处于监听状态(方便客户端随时上传文件,那么服务器(ss)就不用关闭),可以将下面的所有内容放进while中,但是一直处于循环效率太低
        //使用多线程,客户端发出请求就开一个线程去做事,不发请求就不开线程做事,效率高
       while (true){
           Socket so = ss.accept();//获取到请求的客户端对象socket(死循环中accept一直在等待获取用户的请求,处于阻塞状态)
           new Thread(new Runnable() {

               @Override
               public void run() {//由于父类Runnable中run方法没有声明抛出异常,那么子类重写run方法也不能抛出异常,有异常只能tryCatch处理掉
                   try {
                       InputStream is = so.getInputStream();//网络输入流读取客户端文件

                       File file = new File("C:\\ccc");
                       if(!file.exists()){//如果文件不存在则创建一个
                           file.mkdirs();//创建文件夹
                       }

                       //自定义一个文件命名规则,防止文件重名被覆盖(公司域名+系统当前时间毫秒值+随机数+什么类型文件就加什么后缀)
                       String str="\\itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
                       FileOutputStream fos = new FileOutputStream(file+str);

                       int len;
                       byte[] bytes = new byte[1024];
                       while ((len=is.read(bytes))!=-1){//此处会接收到一个客户端socket上传的结束标记,程序不会阻塞
                           fos.write(bytes,0,len);//字节输出流将客户端文件保存到本地
                       }

                       OutputStream os = so.getOutputStream();//网络输出流对客户端数据回写
                       os.write("收到文件并保存".getBytes());
                       fos.close();
                       so.close();
                   }catch (IOException e){
                       System.out.println(e);
                   }
               }
           }).start();
       }


//        ss.close();服务器不用关闭,如果关闭了,再有线程启动就没有服务器对象了



    }
}
