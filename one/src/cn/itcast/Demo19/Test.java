package cn.itcast.Demo19;
//创建测试类
public class Test {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new CiHuo(baoZi).start();
        new BaoZiPu(baoZi).start();
    }
}
