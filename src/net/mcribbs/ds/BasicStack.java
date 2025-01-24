package net.mcribbs.ds;

public class BasicStack<T> implements Stack<T> {
    private T[] data;
    private int stackPointer;

    public BasicStack() {
        data = (T[]) new Object[1];
        stackPointer = 0;
    }

    public void push(T item) {
        if (stackPointer == data.length) {
            T[] newData = (T[]) new Object[data.length*2];
            stackPointer = 0;
            for (T i : data){
                newData[stackPointer++] = i;
            }
            data = newData;
        }
        data[stackPointer++] = item;
    }

    public T pop() {
        if (stackPointer == 0) {
            return null;
        } else {
            T retVal = data[--stackPointer];
            data[stackPointer] = null;
            return retVal;
        }
    }

    public boolean contains(T item) {
        for (T thing : data) {
            if (item.equals(thing)) {
                return true;
            }
        }
        return false;
    }

    public T access(T item) {
        return access(item, true);
    }

    public T access(T item, boolean isDestructive) {
        if (isDestructive) {
            while (stackPointer > 0) {
                T thing = pop();
                if (item.equals(thing)) {
                    return thing;
                }
            }
            return null;
        } else {
            for (T thing : data) {
                if (item.equals(thing)) {
                    return thing;
                }
            }
            return null;
        }
    }

    public int size() {
        return stackPointer;
    }
}
