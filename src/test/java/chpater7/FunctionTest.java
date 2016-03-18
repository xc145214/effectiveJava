package chpater7;


import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/18.
 */
public class FunctionTest {

    @Test
    public void test1() {
        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        p.end().setTime(79);
        System.out.println(p.end());
    }


    @Test
    public void test2() {
        System.out.println(Sum.sum());
        System.out.println(Sum.sum(1));
        System.out.println(Sum.sum(1,2,3,4));
    }


    @Test
    public void test3() {
        System.out.println(Sum.min(1));
        System.out.println(Sum.min(1,2,3,4));
    }
}
