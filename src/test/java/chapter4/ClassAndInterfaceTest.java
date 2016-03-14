

package chapter4;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class ClassAndInterfaceTest {


    @Test
    public void testWeekPublicArray() {
        Week week = new Week(5, 2);
        String[] week_day = week.values();
        for (String day : week_day) {
            System.out.println(day);
        }
    }

    @Test
    public void testWeekPublicList() {
        Week week = new Week(5, 2);
        List<String> week_days = week.VALUES;
        for (String day : week_days) {
            System.out.println(day);
        }
    }


}
