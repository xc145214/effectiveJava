package chapter5;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/3/16.
 */
@SuppressWarnings("unchecked")
public class Stack2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //初始化空间
    public Stack2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 压入元素
     *
     * @param e
     */
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 删除元素
     *
     * @return
     */
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null; /**清空过期引用*/
        return result;
    }

    /**
     * 自动增长栈的空间
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 加入所有
     *
     * @param src
     */
//    public void pushAll(Iterator<? extends E> src) {
//        for (E e : src) push(e);
//    }
}
