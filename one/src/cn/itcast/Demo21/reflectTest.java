package cn.itcast.Demo21;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflectTest {
    //获取字节码class对象的三种方式
   /* public static void main(String[] args) throws ClassNotFoundException {
        //全类名的方式
        Class<?> per3 = Class.forName("cn.itcast.Demo21.Person");
        System.out.println(per3);

        //类名.class
        Class<Person> per1 = Person.class;
        System.out.println(per1);

        //对象的方式
        Person per2 = new Person();
        Class<? extends Person> per2Class = per2.getClass();
        System.out.println(per2Class);

        System.out.println(per1==per2Class&&per1==per3);//获取到的是同一个对象
    }*/

   //Class对象的获取功能之(不带Declare获取的就是公共的,带Declare全部都能获取,但是不能获取到私有的值,需要暴力反射解除安全检查):获取成员变量
   /*public static void main(String[] args) throws Exception {
       Class<Person> personClass = Person.class;

       //1.获取所有成员变量对象(只能获取所有Public修饰的成员变量)
       Field[] fields = personClass.getFields();
       for (Field field : fields) {
           System.out.println(field);
           //public boolean cn.itcast.Demo21.Person.marry
       }

       //2.根据成员变量名获取成员变量对象(只能获取所有Public修饰的成员变量)
       Field marry = personClass.getField("marry");
       System.out.println(marry);//public boolean cn.itcast.Demo21.Person.marry
//       Field age = personClass.getField("age");
//       System.out.println(age);//NoSuchFieldException


       System.out.println("***********************");
       Person p = new Person();
       //3.设置成员变量的值(传递类对象和变量值),获取成员变量对象的值(传递类对象进去)
       marry.set(p,true);
       Object o = marry.get(p);
       System.out.println(o);//true


        //4.获取所有的成员变量对象,不考虑修饰符(但是不能获取pravite修饰的变量的值,除非暴力反射再获取)
       Field[] declaredFields = personClass.getDeclaredFields();
       for (Field declaredField : declaredFields) {
           //System.out.println(declaredField);
           //System.out.println(declaredField.get(p));
           declaredField.setAccessible(true);//忽略访问修饰符的安全检查(暴力反射)
           System.out.println(declaredField.get(p));
       }
       System.out.println("***********************");
       //获取指定名字的成员变量对象,不考虑修饰符(但是不能获取pravite修饰的变量的值,除非暴力反射再获取)
       Field name = personClass.getDeclaredField("name");
       name.setAccessible(true);//暴力反射,否则IllegalAccessException
       System.out.println( name.get(p));
   }*/



    //Class对象的获取功能之:获取构造方法
   /* public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

        //1.获取所有的构造方法
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //2.获取空参构造
        Constructor<Person> constructor = personClass.getConstructor();
        //3.获取带参构造方法(传递参数的字节码进去)
        Constructor<Person> constructor1 = personClass.getConstructor(String.class, int.class, String.class, boolean.class);
        //4.空参构造方法创建对象
        Person person1 = constructor.newInstance();
        //5.全参构造方法创建对象
        Person person2 = constructor1.newInstance("张三", 18, "男", false);
        System.out.println(person2);

        //直接用类的字节码文件创建对象(不用获取到构造方法再创建,但是这是无参构造方法创建对象)
        Person person3 = personClass.newInstance();
        System.out.println(person3);

        //personClass.getDeclaredConstructors();获取所有的构造方法,不考虑修饰符
        //constructor1.setAccessible();也有暴力反射,使用方法同上
    }*/

    //Class对象的获取功能之:获取方法
   /* public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

       //1.获取指定名称的方法(获取空参方法)
        Method eat = personClass.getMethod("eat");
        //3.获取指定名称的方法(获取带参方法)
        Method eat1 = personClass.getMethod("eat", String.class);

        //2.执行方法,传递类对象
        Person p = new Person();
        Object invoke = eat.invoke(p);

        //4.执行方法,传递类对象和参数
        eat1.invoke(p, "shit");

        //获取所有方法名(包括继承的Object父类的方法)
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }

        //获取类名(全类名)
        System.out.println("****************");
        System.out.println( personClass.getName());
        //cn.itcast.Demo21.Person
    }
*/


   //创建一个自动创建对象,调用方法的框架(使用反射,读取配置文件数据,操作数据)
    public static void main(String[] args) throws Exception {
        //1.创建一个properties对象(可以将properties后缀的文件用load方法加载到内存形成一个集合)
        Properties p = new Properties();

        //getClassLoader类加载器可以将类字节码文件加载进内存(classLoader既然可以找到src下的class文件,那当然也能找到src下的配置文件),
        // 使用getResourceAsStream可以获取资源对应的字节流(getResource是获取资源路径)
        //2.使用类加载器调用getResourceAsStream获取到src下的class文件对应的字节流
        ClassLoader classLoader = reflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("Pro.properties");

        //3.调用Properties对象,从流中读取属性列表
        p.load(resourceAsStream);

        //4.获取文件中定义的数据(Person类的全类名)
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");

        //5.操作获取到的数据
            //加载该类进内存
            Class<?> cls = Class.forName(className);
            //创建对象
            Object o = cls.newInstance();
            //获取方法对象
            Method method = cls.getMethod(methodName);
            //执行方法
            method.invoke(o);
    }
}
