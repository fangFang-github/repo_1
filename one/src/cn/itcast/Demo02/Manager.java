package cn.itcast.Demo02;

import java.util.ArrayList;
import java.util.List;

//群主发红包
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public List<Integer> send(int moneyPackage, int num){
        List<Integer> list1=new ArrayList<>();
        int managerMoney = super.getMoney();
        if (moneyPackage>managerMoney){
            System.out.println("余额不足");
            return list1;
        }else {
            int avg = moneyPackage / num;
            int last = moneyPackage % num;
            for (int i = 0; i < num-1; i++) {
                list1.add(avg);
            }
            list1.add(avg+last);
        }
        super.setMoney(managerMoney-moneyPackage);
        return list1;
    }
}
