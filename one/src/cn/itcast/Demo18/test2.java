package cn.itcast.Demo18;
//线程之间的通信(等待唤醒案例wait-notify)
public class test2 {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(){//匿名内部类的方式
            @Override
            public void run() {
                while (true){
                    synchronized (o){
                        System.out.println("顾客1告诉老板要吃什么包子,等包子做好");
                        try {
                            o.wait();//顾客线程进入无限等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("等待结束,顾客1开始吃包子");
                    }
                }
            }
        }.start();





        new Thread(){//匿名内部类的方式
            @Override
            public void run() {
                while (true){
                    synchronized (o){
                        System.out.println("顾客2告诉老板要吃什么包子,等包子做好");
                        try {
                            o.wait();//顾客线程进入无限等待状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("等待结束,顾客2开始吃包子");
                    }
                }
            }
        }.start();






        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (o){
                        try {
                            Thread.sleep(5000);//线程等待5秒钟
                            System.out.println("老板包子做好了,花了五秒钟");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o.notify();//只能随机唤醒一个永久睡眠中的线程
                        o.notifyAll();//包子做好了,唤醒顾客吃包子,不用等了
                    }
                }
            }
        }.start();

    }


}
