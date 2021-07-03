package cn.itcast.Demo06;

public class rice extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("rice"+i);
        }
    }
}
