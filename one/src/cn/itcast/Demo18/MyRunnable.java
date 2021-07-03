package cn.itcast.Demo18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用同步代码块解决线程安全问题(将共享数据用锁给锁住),必须保证多个对象使用的锁对象是同一个
public class MyRunnable implements Runnable {
    private static int num = 100;
    Object o = new Object();//锁对象必须唯一,所以必须创建在外面(不能创建在run方法里面,每个线程都会创建一次run方法)

   /* @Override
    public void run() {
        while (true) {//必须得死循环,不然卖一张票就结束了
            //method2();
          synchronized (o){//必须保证多个对象使用的锁对象是同一个
              if(num>0){
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  for (int i = 1; i <= 100; i++) {
                      System.out.println(Thread.currentThread().getName()+"正在卖第"+num+"张票");
                      num--;
                  }
              }
          }
        }
    }*/

   /* //使用同步方法(同步方法的对象就是实现类对象也就是this)
    public synchronized void method() {
        if (num > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                num--;
            }
        }
    }
       public void method3(){
           synchronized (this) {
               if (num > 0) {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   for (int i = 1; i <= 100; i++) {
                       System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                       num--;
                   }
               }
           }
       }
*/
/*
    //静态的同步方法(静态方法的锁对象是本类的class属性,而不是this,因为静态是优先于对象的,而this是创建对象之后产生的,所以静态方法的锁对象不能是this)
    public static *//*synchronized*//* void method2() {
       synchronized (MyRunnable.class){
           if (num > 0) {//静态只能调用静态,所以num必须是静态的才行
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               for (int i = 1; i <= 100; i++) {
                   System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                   num--;
               }
           }
       }
    }*/


    //解决线程安全的第三种方式lock锁机制
    Lock i= new ReentrantLock();
    @Override
    public void run() {
        try {
            i.lock();//开启锁
            if(num>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+num+"张票");
                    num--;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {//无论代码是否有异常最后都释放锁对象
            i.unlock();//关闭锁
        }
    }
}
