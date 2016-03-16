package chapter5;

import org.junit.Test;

/**
 * Created by Administrator on 2016/3/16.
 */
public class StackTest {

    @Test
    public void stackTest1(){
        Stack2 stack2 = new Stack2<String >();
        stack2.push("hello");
        stack2.push("world");
        stack2.push("java");

        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().toString().toUpperCase());
        }
    }
}
