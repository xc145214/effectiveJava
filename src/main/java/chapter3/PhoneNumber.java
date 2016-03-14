
package chapter3;

/**
 * Created by Administrator on 2016/3/14.
 */
public final class PhoneNumber implements Cloneable{

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 999, "line number");

        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (areaCode != that.areaCode) return false;
        if (prefix != that.prefix) return false;
        return lineNumber == that.lineNumber;

    }

    @Override
    public int hashCode() {
        int result = (int) areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNumber;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * 与PhoneNumber实例比较方法
     * @param phoneNumber 实例
     * @return 比较结果
     */
    public int compareTo(PhoneNumber phoneNumber) {
        //比较 areaCode
        int areaCodeDiff = areaCode - phoneNumber.areaCode;
        if (areaCodeDiff != 0)
            return areaCodeDiff;

        //比较 preifx
        int prefixDiff = prefix - phoneNumber.prefix;
        if (prefixDiff != 0)
            return prefixDiff;

        //比较 lineNumber
        return lineNumber - phoneNumber.lineNumber;
    }


}
