package chapter4;

/**
 * Created by Administrator on 2016/3/16.
 */
class StringComparator1 {

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

}

/**
 * 基础方式
 */
class StringComparator2 {

    private StringComparator2() {
    }

    public static final StringComparator2 INSTANCE = new StringComparator2();

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

/**
 * 接口方式
 */
public class StringComparator implements Compartor<String> {
    private StringComparator() {
    }

    public static final StringComparator INSTANCE = new StringComparator();

    @Override
    public int compare(String t1, String t2) {
        return t1.length() - t2.length();
    }
}