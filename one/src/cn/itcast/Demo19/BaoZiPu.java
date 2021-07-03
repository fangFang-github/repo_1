package cn.itcast.Demo19;
//创建生产包子的包子铺线程类
public class BaoZiPu extends Thread{
    private BaoZi bZ;

    public BaoZiPu(BaoZi bZ) {
        this.bZ = bZ;
    }

    @Override
    public void run() {
        int num=0;//记录包子的生产数量,奇数偶数分别生产不一样的包子
     while (true){
         synchronized (bZ){
             if (bZ.zhuanTai==true){
                 try {
                     bZ.wait();//有包子,让包子铺休息一会
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

             //包子铺线程被唤醒之后会从永久等待这里继续往下执行(开始做包子)
             if(num%2==0){
                 bZ.pi="薄皮";
                 bZ.xian="韭菜猪肉馅";
             }else {
                 bZ.pi="薄皮";
                 bZ.xian="芹菜猪肉馅";
             }
             System.out.println("包子铺正在生产"+bZ.pi+bZ.xian+"的包子");
             try {
                 Thread.sleep(3000);//包子铺生产包子需要三秒钟
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             //包子铺生产完了包子,即修改包子的状态为有
             bZ.zhuanTai=true;
             num++;

             //唤醒吃货线程吃包子
             bZ.notify();
             System.out.println(bZ.pi+bZ.xian+"的包子已经生产好了,吃货可以开始吃了");


         }
     }
    }
}
