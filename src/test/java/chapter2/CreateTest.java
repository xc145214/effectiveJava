package chapter2;

import chapter2.buildPattern.NutritionFacts;
import chapter2.buildPattern.NutritionFacts2;
import chapter2.memoryLeak.Stack;
import chapter2.noinstant.UtilityClass;
import chapter2.singleton.Elvis;
import chapter2.singleton.ElvisA;
import chapter2.singleton.ElvisB;
import chapter2.singleton.ElvisC;
import org.junit.Test;

/**
 * Created by Administrator on 2016/3/9.
 */
public class CreateTest {


    @Test
    public void test1(){
        NutritionFacts cocaCola = new NutritionFacts(240,8,100,0,56,25);
        System.out.println(cocaCola);
    }

    @Test
    public void test2(){
        NutritionFacts2 facts2 = new NutritionFacts2.Builder(240, 8).calories(100).fat(23).sodium(35).carbohydrate(50).build();
        System.out.println(facts2);
    }


    @Test
    public void test3(){
        ElvisA.INSTANCE.leaveTheBuilding();
    }


    @Test
    public void test4(){
        ElvisB.getInstance().leaveTheBuilding();
    }

    @Test
    public void test5(){
        ElvisC.getInstance().leaveTheBuilding();
    }

    @Test
    public void test6(){
        Elvis.INSTANCE.leaveTheBuilding();
    }


    @Test
    public void test7(){
        UtilityClass.too1();

        //new UtilityClass().too1();
    }

    @Test
    public void stackTest(){
        Stack stack = new Stack();
        stack.push("hello");
        stack.push("world");
        stack.push("java");
        stack.pop();
        System.out.println(stack.toString());
    }
}
