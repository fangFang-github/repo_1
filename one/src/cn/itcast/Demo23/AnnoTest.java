package cn.itcast.Demo23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class AnnoTest {//一个测试框架,主方法执行后会自动检测所有需要测试的方法(加了@AnnoDemo1(自定义检测注解)的方法)
    public static void main(String[] args) throws IOException {
        //获取字节码文件
        Class<Student> stu = Student.class;

        //获取所有方法
        Method[] methods = stu.getMethods();

        //定义计数变量和字符缓冲流
        int num=0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("one\\src\\cn\\itcast\\Demo23\\bug.txt"));

        //遍历方法判断
        for (Method method : methods) {
            //判断方法上是否有指定的注解.有就执行方法,捕获异常,将异常写入文档
            if(method.isAnnotationPresent(AnnoDemo1.class)){
                Student student = new Student();//或者使用stu.newInstense创建对象
                try {
                    method.invoke(student);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName()+"方法出现异常了");
                    bw.newLine();//换行
                    //e.getCause()
                    bw.write("异常的名称:"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------");
                    bw.newLine();

                }
            }
        }

        bw.write("本次测试一共出现"+num+"次异常");
        System.out.println("本次测试一共出现"+num+"次异常");
        bw.close();

    }
}
