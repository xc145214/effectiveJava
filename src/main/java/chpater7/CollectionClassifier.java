package chpater7;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2016/3/18.
 */
public class CollectionClassifier {

    public static String classify(Collection<?> c) {
        return c instanceof Set ? "set" : c instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}
