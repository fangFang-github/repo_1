package cn.itcast.Demo17;
//线程名称的两种设置方法(对象.setName设置和构造方法设置)
public class test {
    public static void main(String[] args) throws InterruptedException {
       /* new MyThread().start();//没名字使用默认的,比如Thread1...

        MyThread myThread = new MyThread();
        myThread.setName("奶茶");//取名,然后调用run方法获取正在执行的线程的名字
        myThread.start();

        new MyThread("聪聪").start();//带参数构造方法取名*/

       /* //线程的睡眠方法(静态方法可以用类名直接调用),毫秒值结束后继续执行
        for (int i = 1; i < 60; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }*/

       //匿名内部类的方式创建多线程程序
        //方式一
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"中国");
            }
        }.start();

        //方式二
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "美国");
            }
        };
        Thread thread = new Thread(run);
        thread.start();

    }
}
