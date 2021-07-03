package cn.itcast.Demo19;
//创建吃包子的吃货线程类
public class CiHuo extends Thread{
    private BaoZi bZ;

    public CiHuo(BaoZi bZ) {
        this.bZ = bZ;
    }

    @Override
    public void run() {
       while (true){
           synchronized (bZ){//以包子类作为锁对象
               if(bZ.zhuanTai==false){
                   try {
                       bZ.wait();//没有包子,吃货就等待包子出炉
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

               //吃货被唤醒
               System.out.println("吃货开始吃"+bZ.pi+bZ.xian+"的包子");

               //吃完了修改包子的状态为无
               bZ.zhuanTai=false;

               //唤醒包子铺线程开始做包子(吃货线程吃包子的任务执行完了,就唤醒包子铺线程做任务,因此bZ.notify();锁对象唤醒的是包子铺对象)
               bZ.notify();
           }
       }
    }
}
