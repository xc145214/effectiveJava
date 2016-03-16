package chapter4;

import java.util.AbstractList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/16.
 */
public final class Sub extends Super {
    private final Date date;

    Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }

    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldVal = a[index];
                a[index] = element;
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }


}
