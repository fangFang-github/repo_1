package cn.itcast.Demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//斗地主的发牌
public class DouDiZhu {
    public static void main(String[] args) {
        //准备集合
        List<String> Pokerbox = new ArrayList<>();
        List<String> huaSe = new ArrayList<>();
        List<String> num = new ArrayList<>();

        //集合中添加数据
        Collections.addAll(huaSe,"♠","♥","♦","♣");

        for (int i = 2; i <= 10; i++) {
            num.add(""+i);//这里注意要用""+i,才能将变量转为字符串
        }
        num.add("J");
        num.add("Q");
        num.add("K");
        num.add("A");

        for (String s : huaSe) {
            for (String s1 : num) {
                Pokerbox.add(s+s1);
            }
        }
        Pokerbox.add("大王");
        Pokerbox.add("小王");

        //洗牌
        Collections.shuffle(Pokerbox);


        //发牌(重点)
        List<String> liBai = new ArrayList<>();
        List<String> duPu = new ArrayList<>();
        List<String> huangShang = new ArrayList<>();
        List<String> diPai = new ArrayList<>();

        /*for (int i = 1; i < Pokerbox.size()+1; i++) {//Pokerbox的索引从0-53,长度为54
            String pai= Pokerbox.get(i-1);//写在这里增加效率
            if(i>51){
                diPai.add(pai);
            }else {
                if(i%3==0){//这里是i%3不是i/3,所以i可以为0(如果是/3就不能为0)
                    liBai.add(pai);
                }else if(i%3==1){
                    duPu.add(pai);
                }else{
                    huangShang.add(pai);
                }
            }
        }
*/


        for (int i = 0; i < Pokerbox.size(); i++) {//Pokerbox的索引从0-53,长度为54
            String pai= Pokerbox.get(i);//写在这里增加效率
            if(i>50){
                diPai.add(pai);
            }else {
                if(i%3==0){//这里是i%3不是i/3,所以i可以为0(如果是/3就不能为0)
                    liBai.add(pai);
                }else if(i%3==1){
                    duPu.add(pai);
                }else{
                    huangShang.add(pai);
                }
            }
        }



        //地主随机做
        int i = new Random().nextInt(3);//012
        System.out.println(diPai);
        if(i==0){
           liBai.addAll(diPai);
        }else if(i==1){
            duPu.addAll(diPai);
        }else {
            huangShang.addAll(diPai);
        }


        //看牌(使用Lambda内部遍历的方法forEach)
        System.out.print("李白的牌:"+liBai.size());
        liBai.forEach(item-> System.out.print(item));
        System.out.println();
        System.out.print("杜甫的牌:"+duPu.size());
        duPu.forEach(item-> System.out.print(item));
        System.out.println();
        System.out.print("皇上的牌:"+huangShang.size());
        huangShang.forEach(item-> System.out.print(item));





    }
}
