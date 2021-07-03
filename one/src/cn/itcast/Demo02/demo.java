package cn.itcast.Demo02;

import java.util.List;

//测试类
public class demo {
    public static void main(String[] args) {
        Manager man = new Manager("皇帝", 100);
        emp emp1 = new emp("甄嬛", 0);
        emp emp2 = new emp("华妃", 0);
        emp emp3 = new emp("浣碧", 0);
        man.show();
        emp1.show();
        emp2.show();
        emp3.show();

        List<Integer> send = man.send(50, 3);
        emp1.recive(send);
        emp2.recive(send);
        emp3.recive(send);

        man.show();
        emp1.show();
        emp2.show();
        emp3.show();


    }
}
