package chapter6;

import org.junit.Test;

/**
 * Created by Administrator on 2016/3/16.
 */
public class WeightTest {

    @Test
    public void weightTest() {
        double earthWeight = Double.parseDouble("175.000000");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }

    @Test
    public void operationTest() {
        double x = Double.parseDouble("2.00");
        double y = Double.parseDouble("4.00");
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

    @Test
    public void operation1Test() {
        double x = Double.parseDouble("2.00");
        double y = Double.parseDouble("4.00");
        for (Operation1 op : Operation1.values())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

    @Test
    public void test1() {
        System.out.println(PayrollDay.MONDAY.pay(10,0.8));
        System.out.println(PayrollDay.SATURDAY.pay(10,0.8));
    }


}
