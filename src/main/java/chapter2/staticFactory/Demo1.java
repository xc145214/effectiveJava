package chapter2.staticFactory;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/3/8.
 */
public class Demo1 {
    /**
     * 静态工厂构造方法
     *
     * @param b
     * @return
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 静态工厂方法
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }
}
