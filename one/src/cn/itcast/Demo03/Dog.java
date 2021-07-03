package cn.itcast.Demo03;

public class Dog extends Animal {
    @Override
     void eat() {
        System.out.println("吃粑粑");
    }

    public void daiLu(){
        System.out.println("导盲犬可以带路");
    }
}
