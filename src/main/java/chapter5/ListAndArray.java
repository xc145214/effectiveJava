package chapter5;

import java.util.*;

/**
 * Created by Administrator on 2016/3/16.
 */
public class ListAndArray {
    public static void main(String[] args) {

        //数组是协变的
//        Object[] objects = new Long[1];
//        objects[0] = "I don't fit in";

        /**
         * 泛型不可变
         */
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("I don't fit in");


        Set<String > guys = new HashSet<String >(Arrays.asList("Tom","Dick","Harry"));
        Set<String > stooges = new HashSet<String >(   Arrays.asList("Larry","Moe","Curly"));
        Set<String > aflCio = union(guys,stooges);
        System.out.println(aflCio);
    }


    public static <E> Set<E> union(Set<E> s1,Set<E> s2){
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

}
