package chapter6;

/**
 * Created by Administrator on 2016/3/16.
 */
// Abuse of ordinal to derive an associated value - DON'T DO THIS
public enum Ensemble1 {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}