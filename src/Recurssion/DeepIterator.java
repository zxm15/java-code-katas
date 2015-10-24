package Recurssion;

import java.util.*;

/**
 * Created by ZXM on 10/24/15.
 * 写一个deepIterator来iterate一个collection. Collection是那种nested结构的。比如：
 * {{1, 2, 3}, 4, {{5, 6}, {{7}}}, {8, 9, 10}}
 * 这种就要返回1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 */

public class DeepIterator implements Iterator {

    private Integer top;
    private Stack<Iterator> iteratorStack;

    public DeepIterator(Iterable iterable) {
        iteratorStack = new Stack<>();
        iteratorStack.push(iterable.iterator());
    }

    @Override
    public boolean hasNext() {
        if (top != null) return true;
        while (!iteratorStack.isEmpty()) {
            Iterator iterator = iteratorStack.peek();
            if (! iterator.hasNext()) {
                iteratorStack.pop();
                continue;
            }
            Object data = iterator.next();
            if (data instanceof Integer) {
                top = (Integer) data;
                return true;
            } else if (data instanceof  Iterable) {
                iteratorStack.push(((Iterable) data).iterator());
            } else {
                throw new RuntimeException("Unsupported data structure");
            }
        }

        return false;

    }

    @Override
    public Integer next() {
        if (! hasNext()) throw new NoSuchElementException();
        Integer temp = top;
        top = null;
        return temp;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This is not supported right now");
    }
    public static void main(String[] args) {
        List list = new LinkedList<>();
        list.add(1);
        list.add(new LinkedList(Arrays.asList(2, new LinkedList(Arrays.asList(4,5)))));
        list.add(6);
        list.add(new HashSet(Arrays.asList(7,8,9)));
        DeepIterator solution = new DeepIterator(list);
        List<Integer> res = new LinkedList<>();
        while(solution.hasNext()) {
            Integer i = solution.next();
            System.out.println(i);
            res.add(i);
        }
        System.out.println(res.toString());

    }
}
