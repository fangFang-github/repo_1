package cn.itcast.Demo22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//使用注解替代配置文件(ClassName = "cn.itcast.Demo22.Student"不要把package写进去了)
@AnnoDemo1(ClassName = "cn.itcast.Demo22.Student",MethodName = "study")
public class test {
    public static void main(String[] args) throws Exception {
        //1.获取字节码对象(谁有注解就获取谁的)
        Class<test> testClass = test.class;

        //2.根据字节码对象获取指定名称的注解对象(传递注解的.class)
        AnnoDemo1 an = testClass.getAnnotation(AnnoDemo1.class);

        //3.根据注解对象获取抽象方法(属性)值
        String ClassName = an.ClassName();
        String MethodName = an.MethodName();


        //4.根据全类名,获取类的字节码文件
        Class cls = Class.forName(ClassName);

        //5.根据字节码文件创建对象
        Object o = cls.newInstance();

        //5.根据类对象获取方法
        Method method = cls.getMethod(MethodName);

        //6.执行方法
        Object invoke = method.invoke(o);
    }
}
