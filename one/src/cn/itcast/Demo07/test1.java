package cn.itcast.Demo07;

import java.io.File;
import java.io.FileFilter;

//使用listFiles的重载方法(fileFileter中的accept方法进行文件过滤)(原理,将files中的元素传递到accept中,把进行过滤后的元素再放回files数组中)
public class test1 {
    public static void main(String[] args) {
        File file4 = new File("H:\\Program Files (x86)\\360\\360zip");
        method5(file4);
    }

    private static void method5(File file4) {
        //这是匿名对象(省略的是左边的对象名fileter的创建) FileFileterImpl fileter = new FileFileterImpl();
        File[] files = file4.listFiles(new FileFileterImpl());
        file4.listFiles(new FileFilter() {//这是匿名内部类,省略了实现类的创建,也省略了实现类对象的创建
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
            }
        });

    }
}

