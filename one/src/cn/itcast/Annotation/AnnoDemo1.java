package cn.itcast.Annotation;
//@Override检测是否继承自父类(是否是覆盖重写),@Deprecated//过时注解,@SuppressWarnings("all")//压制警告(将警告隐藏)
/**
 * @version 1.0
 * @author itheima
 * @since 1.5
 */

@SuppressWarnings("all")//压制警告
//@AnnoDemo2(add=1,method = "lisi")
@AnnoDemo2(add=1,value = true,per = Person.p1,ann = @AnnoDemo3,array = {"aaa","bbb"})
public class AnnoDemo1 {
    /**
     *计算两数之和
     * @param a 元素a是一个整数
     * @param b 元素b是一个整数
     * @return  返回两数之和
     */
    public int add(int a,int b){
        return a+b;
    }


    @Deprecated//过时注解
    public void method1(){
        System.out.println("过时了");
    }

    public void method2(){
        System.out.println("替代方法");
    }


    //
}
