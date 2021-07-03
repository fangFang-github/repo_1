package cn.itcast.Demo20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
       /* ExecutorService pool = Executors.newFixedThreadPool(2);//创建有两个线程的线程池

        pool.submit(new RunnableImpl());//传递线程任务,线程池调用submit方法开启线程 pool-1-thread-1

        pool.submit(new RunnableImpl());//传递线程任务,开启线程 pool-1-thread-1

        pool.submit(new RunnableImpl());//传递线程任务,开启线程 pool-1-thread-2
        //线程会一直开启(处于等待使用状态),线程使用完毕会自动归还到线程池中,线程池中的线程不够使用会等待归还后再使用
        pool.shutdown();//销毁线程池,不建议使用*/


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
