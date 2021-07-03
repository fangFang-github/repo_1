package cn.itcast.Demo06;

import java.util.Scanner;

public class Regis {
   static String [] array={"张三","李四"};
    public static void main(String[] args) throws RegisException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要注册的用户名:");
        String next = sc.next();
        method(next);
    }

    /*public static void method(String next) *//*throws RegisException*//* {
        for (String s : array) {
            if(next.equals(s)){
//                throw new RegisException("用户名已被注册");
                try {
                    throw new RegisException("用户名已被注册");
                }catch (RegisException e){
                    e.printStackTrace();//打印异常信息
                    return;//结束语句(不然下面的注册成功也会执行)(throws下面的语句不会执行但是try catch后面的语句没结束还会执行)
                }
            }
        }
        System.out.println("注册成功");
    }*/


    public static void method(String next){
            for (String s : array) {
        if(next.equals(s)){
            //因为RegisException继承的是运行时异常,所以我们无需处理(不用try catch也不用throws),交给虚拟机处理,暂停处理即可
                throw new RegisException("用户名已被注册");
        }
    }
        System.out.println("注册成功");
}


}
