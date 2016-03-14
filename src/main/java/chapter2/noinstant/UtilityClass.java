package chapter2.noinstant;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

/**
 * 不能实例化的工具类
 * Created by Administrator on 2016/3/9.
 */
public class UtilityClass {

    private UtilityClass(){
        //防止内部实例化
        throw new AssertionError("noninstantiable utility class");
    }


    public static void too1(){
        System.out.println("static method");
    }
}
