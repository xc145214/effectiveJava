package chapter2.singleton;

import sun.text.normalizer.UBiDiProps;

import java.io.ObjectInput;
import java.io.Serializable;

/**
 * 静态工厂序列化
 * Created by Administrator on 2016/3/9.
 */
public class ElvisC implements Serializable {
    public static final ElvisC INSTANCE = new ElvisC();

    public static ElvisC getInstance() {
        return INSTANCE;
    }

    /**
     * readResolve method to preserve singleton property
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }
    /**
     * 私有构造
     */
    private ElvisC() {
        System.out.println(" ElvisC private construct");
    }

    public void leaveTheBuilding() {
        System.out.println(" ElvisC public method");
    }



}
