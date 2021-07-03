package cn.itcast.Demo05;

import java.util.*;

//测试类(Collections的sort排序方法,自定义类需要实现Compareble接口(注意要给接口定义泛型为CompareTo的参数类型即Person),
// 重写排序方法CompareTo,自定义类作为参数传递,返回this到o是降序,反之升序)
public class test {
    public static void main(String[] args) {
        Person p1 = new Person("b张三", 15);
        Person p2 = new Person("李四", 16);
        Person p3 = new Person("王五", 17);
        Person p4 = new Person("a王麻子", 15);

        List<Person> list = new ArrayList<>();
        Collections.addAll(list,p1,p2,p3,p4);

       /* //第一种排序方法 Compareble(自己跟别人比较,自己实现Compareble接口重写比较的方法)
        Collections.sort(list);
        Iterator<Person> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());//Person类重写了toString方法,所以可以直接输出对象名
        }*/


       /*//第二种排序方法 Comparetor(传入比较器来进行比较)
       Collections.sort(list, new Comparator<Person>() {
           @Override
           public int compare(Person o1, Person o2) {
              //return 0;
                int result= o1.getAge()-o2.getAge();//按照年龄升序
               if(result==0){//如果年龄相同就按名字的第一个字升序
                   result= o1.getName().charAt(0)-o2.getName().charAt(0);
               }
               return result;
           }
       });
        System.out.println(list);
*/

//第二种的匿名内部类写法改为lambda表达式
//Lambda表达式代替匿名内部类的注意事项,当匿名内部类实现的接口中或者父类中,抽象方法仅有一个时才能使用Lambda表达式
        //当接口中抽象方法的参数为两个或多个时,参数要用括号括起来,箭头后的方法体大括号不能省,return关键字也不能省
        //当这个接口有指定泛型时,比如"new Comparator<Person>() {"泛型为Person类型,那么抽象方法的参数数据类型不能省
      Collections.sort(list,(Person o1,Person o2)->{
          int result=o1.getAge()-o2.getAge();
          if(result==0){
              result=o1.getName().charAt(0)-o2.getName().charAt(0);
          }
          return result;
      });

        System.out.println(list);

    }
}


