package cn.itcast.Demo09;

@FunctionalInterface//定义一个函数式接口(接口中只有一个抽象方法)
public interface Greetable {
    void jianMiam();//见面的方法,没有参数,所以重写时也没有参数,只能在方法体中做文章
}
