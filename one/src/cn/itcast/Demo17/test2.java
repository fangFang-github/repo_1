package cn.itcast.Demo17;
//创建多线程的第二种方式(将Runnable的实现类对象作为Thread的参数传递,再调用start开启线程)
public class test2 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr);
        thread.start();

        for (int i = 0; i < 500; i++) {//main方法和线程抢夺cpu的执行权
            System.out.println(Thread.currentThread().getName());
        }
    }
}
