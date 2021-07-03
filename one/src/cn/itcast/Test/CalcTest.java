package cn.itcast.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;//导入junit依赖环境

public class CalcTest {
    @Before//最开始执行
    public void init(){
        System.out.println("初始化...");
    }

    @Test
    public void testAdd(){
        Calc c = new Calc();
        int num = c.add(1, 2);
        //System.out.println(num);
       Assert.assertEquals(3,num);//断言操作,预想结果跟实际结果一致则进度条显示绿色,否则红色错误

    }

    @Test
    public void testSubmit(){
        Calc c = new Calc();
        int num = c.submit(1, 2);
        Assert.assertEquals(-1,num);
    }

    @After
    public void close(){//最后执行(无论中间是否出错都一定会执行)
        System.out.println("释放资源");
    }
}
