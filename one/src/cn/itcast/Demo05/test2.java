package cn.itcast.Demo05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*HashMap是一个无序的双列集合,而LinkedHashMap是有序的双列集合
* HashMap集合(之前学的所有集合)都可以存储空值空键,但是Hashtable不能存储空值空键
* Hashtable线程安全,单线程,速度慢,jdk1.0之前的老集合,用的少,但是
* Hashtable的子类Properties(唯一与IO流相结合的集合),依然常用
* */
public class test2 {
    public static void main(String[] args) {
        //Map<Person, String> personMap = new HashMap<>();
        Map<Person, String> personMap = new LinkedHashMap<>();
        personMap.put(new Person("张三", 15), "中国");
        personMap.put(new Person("李四", 16), "美国");
        personMap.put(new Person("王五", 17), "英国");

        Set<Map.Entry<Person, String>> set = personMap.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }
}
