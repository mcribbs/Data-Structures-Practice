package net.mcribbs.ds;

import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {
    private ArrayList<T> data;

    public ListStack() {
        data = new ArrayList<T>();
    }

    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (data.isEmpty()) {
            return null;
        } else {
            int sp = data.size() - 1;
            T thing = data.get(sp);
            data.remove(sp);
            return thing;
        }
    }

    public boolean contains(T item) {
        return data.contains(item);
    }

    public T access(T item) {
        int sp = data.size() - 1;
        while (sp > 0) {
            T thing = pop();
            sp = data.size() - 1;
            if (item.equals(thing)) {
                return thing;
            }
        }
        return null;
    }

    public int size() {
        return data.size() - 1;
    }
}
