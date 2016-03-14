package chapter2.memoryLeak;


import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Administrator on 2016/3/9.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //初始化空间
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 压入元素
     *
     * @param e
     */
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 删除元素
     *
     * @return
     */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
//        return elements[--size];
        Object result = elements[--size];
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : elements) {
            if (object != null)
                stringBuilder.append(object.toString()).append("\t");
        }
        return stringBuilder.toString();
    }
}
