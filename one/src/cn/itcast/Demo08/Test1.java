package cn.itcast.Demo08;

import java.util.Calendar;

public class Test1 {
   public static void dog(Animal animal){
       animal.name("wangCai");
   }

   public static void cole(int num,Calcable cal){
       System.out.println(cal.abs(num));
   }

    public static void main(String[] args) {
        //dog(c-> System.out.println(c));//使用Lambda表达式

       /*
       使用对象名引用成员方法
       //dog(System.out::println);//使用方法引用(对象直接调方法,省略了参数)


        //dog(c->new daXie().method(c));

        dog(new daXie()::method);//使用方法引用,但是参数一定要为方法可以接收的类型*/

        cole(-10,c->Math.abs(c));//使用Lambda表达式简化匿名内部类(否则得写个接口或匿名内部类传进去)

        cole(-20,Math::abs);//方法引用替代Lambda,通过类名引用静态成员方法

    }


}
