package cn.itcast.Demo18;

public class Test {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        new Thread(mr).start();
        new Thread(mr).start();
        new Thread(mr).start();
    }
}
