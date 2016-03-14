
package chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Week {

    private final int workDays;
    private final int noWorkDays;

    public Week(int workDays, int noWorkDays) {
        this.workDays = workDays;
        this.noWorkDays = noWorkDays;
    }

    public int getWorkDays() {
        return workDays;
    }

    public int getNoWorkDays() {
        return noWorkDays;
    }

    /**
     * 类具体public 的静态 final 数组域或者返回这种域的访问方法，几乎总是错误的
     */
    private static final String[] WEEK_DAY = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    /**
     * method
     * @return
     */
    public static final String[] values() {
        return WEEK_DAY.clone();
    }

    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(WEEK_DAY));


}
