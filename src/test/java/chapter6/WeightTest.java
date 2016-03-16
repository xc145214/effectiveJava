package chapter6;

import org.junit.Test;

import java.util.*;

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
        System.out.println(PayrollDay.MONDAY.pay(10, 0.8));
        System.out.println(PayrollDay.SATURDAY.pay(10, 0.8));
    }

    @Test
    public void test2() {
        System.out.println(Ensemble1.QUARTET.numberOfMusicians());
        System.out.println(Ensemble.TRIPLE_QUARTET.numberOfMusicians());
    }

    @Test
    public void textTest() {
        new Text1().applyStyles(Text1.STYLE_ITALIC);
        new Text1().applyStyles(Text1.STYLE_ITALIC | Text1.STYLE_STRIKETHROUGH);
        new Text2().applyStyles(EnumSet.of(Text2.Style.STYLE_ITALIC, Text2.Style.STYLE_STRIKETHROUGH));
    }


    @Test
    public void herbTest() {
        Herb[] garden = {
                new Herb("herb1", Herb.Type.ANNUAL),
                new Herb("herb2", Herb.Type.ANNUAL),
                new Herb("herb3", Herb.Type.ANNUAL),
                new Herb("herb4", Herb.Type.BIENNIAL),
                new Herb("herb5", Herb.Type.BIENNIAL),
                new Herb("herb6", Herb.Type.PERENNIAL),
                new Herb("herb7", Herb.Type.PERENNIAL)
        };
        Map<Herb.Type, Set<Herb>> herbsByType =
                new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
        for (Herb.Type t : Herb.Type.values())
            herbsByType.put(t, new HashSet<Herb>());
        for (Herb h : garden)
            herbsByType.get(h.getType()).add(h);
        System.out.println(herbsByType);
    }
}
