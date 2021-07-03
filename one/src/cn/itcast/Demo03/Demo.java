package cn.itcast.Demo03;

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
//       animal.daiLu;//向上转型为父类动物类此为多态,多态不能调用子类特有方法(父类不能调用子类特有方法),需要向下转型为dog类
        if(animal instanceof Dog){//向下转型是大范围转向小范围,有可能类型不对会失败,先判断类型,如果是再转
            Dog dog=(Dog) animal;
            dog.daiLu();
        }

    }
}
