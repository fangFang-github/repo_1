package cn.itcast.Demo11;

public class test {
    static int[] method(int length,ArrayBuilder ar){
        int[] array1 = ar.array1(length);
        System.out.println(array1.length);
        return array1;
    }

    public static void main(String[] args) {
        method(10,length->new int[length]);

        method(10,int[]::new);//方法引用int[]引用new,数组构造器的引用
    }
}
