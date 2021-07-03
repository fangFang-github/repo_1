package cn.itcast.Demo06;
//创建多线程的第一种方式,创建Thread的子类,并重写run方法(定义启动这个线程要做什么),然后在主线程中,用Thread子类的对象调用父类start方法启动线程(然后就有了主线程和其他线程抢占式调度)
public class apple {
    public static void main(String[] args) {
        rice r1 = new rice();
        r1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("apple"+i);
        }


    }
}
