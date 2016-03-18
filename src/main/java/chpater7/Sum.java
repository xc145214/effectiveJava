package chpater7;

import org.jetbrains.annotations.Contract;

/**
 * Created by Administrator on 2016/3/18.
 */
public class Sum {

    @Contract(pure = true)
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }


    static int min(int first,int...args){
        int min =first;
        for (int arg :args)
            if(arg<min)
                min=arg;
        return min;
    }
}
