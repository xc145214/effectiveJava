package chapter4;


import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/14.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    public int getAddCount() {
        return addCount;
    }

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }



}


