package cn.itcast.Demo22;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//作用于方法
@Retention(RetentionPolicy.RUNTIME)//保留到运行时阶段
public @interface AnnoDemo1 {
    String ClassName();
    String MethodName();

}
