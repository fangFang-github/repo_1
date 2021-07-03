package cn.itcast.Demo23;


public class Student {

    @AnnoDemo1
    public void study(){
        System.out.println("学生在学习");
    }

    @AnnoDemo1
    public void cale(){
        System.out.println(1/0);
    }

    @AnnoDemo1
    public void cale2(){
        String a=null;
        a.toString();
    }

    public void study2(){
        System.out.println("学生放学了");
    }

}
