package cn.itcast.Demo17;

public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);//线程名称传递给父类,让父类给子类起一个名字
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
