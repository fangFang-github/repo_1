package cn.itcast.Annotation;
//定义注解(使用注解时,必须对注解中的抽象方法赋值,@AnnoDemo2(add=1),这里的add就像属性名,1像是属性值,因此注解中的抽象方法也叫做属性)

import java.lang.annotation.*;

@Target({ElementType.TYPE})//描述注解作用的位置在类上
@Retention(RetentionPolicy.RUNTIME)//描述注解被保留的阶段(Runtime运行时,Class类对象,Resource源代码)
@Documented//描述注解是否被抽取到api到文档中
@Inherited//描述注解是否被子类继承
public @interface AnnoDemo2 {

    //注解其实就是一个接口,javap xxxx.class反编译可知
    //注解的属性就是接口中的抽象方法,注解的属性的返回值类型只能是:基本数据类型,String,枚举,注解,以上类型的数组,此外都不行
    int add();

    String method() default "zhangsan";//有默认值时,使用注解可以不用赋值

    boolean value();//属性名为value时,并且注解只有这一个属性时,value可省略@AnnoDemo2(true),由此可见SuppressWarnings("all")的属性名为value,返回值为String

    Person per();//抽象方法的返回值是Person类,是一个枚举类,方法名叫per

    AnnoDemo3 ann();

    String[] array();

}
