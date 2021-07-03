package cn.itcast.Demo09;
public class man extends Human {
    @Override
    public void sayHello() {
        System.out.println("Helle,我是子类");
    }

    public void method(Greetable gre){
        gre.jianMiam();//调用函数式接口的见面方法
    }

    /*public void show(){//展示方法,内部调用method方法,参数是函数式接口,所以可以用Lambda表达式
        // Greetable接口中的jianmian方法没有参数,Lambda表达式参数不写,只写返回值即可,匿名对象调用父类的sayHello方法作为返回值
        method(()->new Human().sayHello());
        method(()->super.sayHello());
    }*/

    public void show(){
        method(new Human()::sayHello);//方法引用,通过对象名直接调用方法,不必写参数,直接写对参数的操作
        method(super::sayHello);//在子父类关系中,可以直接用super代表父类,调用父类中的方法,而不必创建一个父类对象
        method(this::sayHello);
    }

    public static void main(String[] args) {
        new man().show();//因为show方法不是静态的,所以只能对象调用(如果把show方法改为静态的,那么内部调用的method方法也必须是静态的,
                        // 但是静态方法中不能使用this和super(因为this和super代表调用函数对象的引用属于对象),所以此处只能对象调用)
    }
}
