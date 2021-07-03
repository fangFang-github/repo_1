package cn.itcast.Demo10;

public class test {
    static void method(String name,JoinPerson j){
        Person person = j.joinPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        method("李白",name->new Person(name));//Lambda同匿名内部类一样,重写接口中的抽象方法,补全该方法的功能
        method("张三",Person::new);//方法引用,类的构造器的引用

    }

}
