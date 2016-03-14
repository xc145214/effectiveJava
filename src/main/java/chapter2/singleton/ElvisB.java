package chapter2.singleton;

/**
 * 静态工厂方法
 * Created by Administrator on 2016/3/9.
 */
public class ElvisB {
    private static final ElvisB INSTANCE = new ElvisB();

    public static ElvisB getInstance() {
        return INSTANCE;
    }

    /**
     * 私有构造
     */
    private ElvisB() {
        System.out.println(" ElvisB private construct");
    }

    public void leaveTheBuilding() {
        System.out.println(" ElvisB public method");
    }


    public static void main(String[] args) {
        ElvisB.getInstance().leaveTheBuilding();
    }
}
