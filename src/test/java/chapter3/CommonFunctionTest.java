package chapter3;

import org.junit.Test;

/**
 * Created by Administrator on 2016/3/14.
 */
public class CommonFunctionTest {

    @Test
    public void toStringTest() {
        PhoneNumber phoneNumber = new PhoneNumber(12, 230, 156);
        System.out.print(phoneNumber);
    }

    @Test
    public void compareToTest() {
        PhoneNumber phoneNumber1 = new PhoneNumber(12, 230, 156);
        PhoneNumber phoneNumber2 = new PhoneNumber(13, 228, 165);
        System.out.println(phoneNumber1.compareTo(phoneNumber2));
    }


    @Test
    public void cloneTest() {
        PhoneNumber phoneNumber = new PhoneNumber(12, 230, 156).clone();
        System.out.print(phoneNumber);
    }
}
