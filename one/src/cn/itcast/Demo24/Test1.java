package cn.itcast.Demo24;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test1 implements Serializable{
    public static void main(String[] args) throws Exception {

        List<Student> stu = new ArrayList<>();
        stu.add(new Student("张三",18));
        stu.add(new Student("李四",20));
        stu.add(new Student("王五",22));
        stu.add(new Student("赵六",24));









      //对象的序列化流(把对象从内存写到硬盘)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\a.txt"));

        oos.writeObject(stu);
        oos.close();

        //转换流(将u8转成gbk)
        InputStreamReader isr = new InputStreamReader(new FileInputStream("F:\\a.txt"),"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\b.txt"),"gbk");
        int len=0;
        while ((len=isr.read())!=-1){
                osw.write(len);
        }
        osw.close();
        isr.close();

        //对象的反序列化流(将保存在硬盘中的对象以流的方式读出来)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\a.txt"));
            Object o = ois.readObject();
        ArrayList<Student> o1 = (ArrayList<Student>) o;
        for (Student s : o1) {
            System.out.println(s.getName()+s.getAge());
        }
            ois.close();





    }

}
