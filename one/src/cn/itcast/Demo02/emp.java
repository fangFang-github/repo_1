package cn.itcast.Demo02;

import java.util.List;
import java.util.Random;

//成员收红包
public class emp extends User{
    public emp() {
    }

    public emp(String name, int money) {
        super(name, money);
    }

    public void recive(List<Integer> list){
        Integer reciveMoney = list.remove(new Random().nextInt(list.size()));
        int empMoney = super.getMoney();
        super.setMoney(reciveMoney+empMoney);
    }
}
