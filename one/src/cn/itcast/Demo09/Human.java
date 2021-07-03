package cn.itcast.Demo09;

public class Human {
    public void sayHello(){//static是属于类的(所谓静态就是Jvm虚拟机在运行时已经认定此方法属于哪个类),只能类名调用,不属于对象,就不能被对象覆盖重写
        System.out.println("Hello,我是父类");
    }
}
