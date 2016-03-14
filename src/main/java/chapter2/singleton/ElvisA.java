package chapter2.singleton;

/**
 * singleton with public final field,
 * 但是可以通过反射调用私有构造器
 * Created by Administrator on 2016/3/9.
 */
public class ElvisA {

    public static final ElvisA INSTANCE = new ElvisA();

    /**
     * 私有构造
     */
    private ElvisA()  {
        System.out.println(" ElvisA private construct");
    }

    public void leaveTheBuilding(){
        System.out.println(" ElvisA public method");
    }


    public static void main(String[] args)  {
        ElvisA.INSTANCE.leaveTheBuilding();
    }
}
