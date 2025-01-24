package net.mcribbs.ds;

public class BasicQueue<T> implements Queue<T> {
    private T[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1);
    }

    public BasicQueue(int size) {
        data = (T[]) new Object[size];
        front = -1;
        end = -1;
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else if (front <= end) {
            return end - front + 1;
        } else {
            return (data.length - front + 1) + end + 1;
        }
    }

    public void enQueue(T item) {
        // full, time to grow
        if (size() == data.length) {
            T[] newData = (T[]) new Object[data.length*2];

            if (front <= end) { // non wrapping
                int j = -1;
                for (int i = front; i <= end; i++) {
                    newData[++j] = data[i];
                }
                end = j;
            } else { // wrapping
               int j = -1;
               for (int i = front; i < data.length; i++) {
                   newData[++j] = data[i];
               }
               for (int i = 0; i <= end; i++) {
                   newData[++j] = data[i];
               }
               end = j;
            }
            front = 0;
            data = newData;
        }

        if (front == -1) { // first item
            front++;
        }
        else if (end == data.length - 1) { // end of the array, wrap
            end = -1;
        }

        //increment and add
        data[++end] = item;
    }

    public T deQueue() {
        T retVal = null;

        if (size() == 0) {
            throw new IllegalStateException("Empty");
        }
        else {
            retVal = data[front];
            data[front] = null;

            if (front == end) { // removed the last item
                front = -1;
                end = -1;
            }
            else if (front == data.length) { // time to wrap
                front = 0;
            } else { // just a normal remove
                front++;
            }
        }
        return retVal;
    }

    public boolean contains(T item) {
        if (size() == 0) {
            return false;
        } else if (front <= end) { // non wrapping
            for (int i = front; i <= end; i++) {
                if (item.equals(data[i])) {
                    return true;
                }
            }
        } else { // wrapping
            for (int i = front; i <= data.length; i++) {
                if (item.equals(data[i])) {
                    return true;
                }
            }
            for (int i = 0; i <= end; i++) {
                if (item.equals(data[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public T access(T item) {
        while (size() > 0) {
            T thing = deQueue();
            if (item.equals(thing)) {
                return thing;
            }
        }
        return null;
    }

    public T access(int position) {
        if (size() == 0 || position > size()) {
            throw new IllegalArgumentException("Index out of bounds");
        } else if (front < end) { // non wrapping
            return data[front + position - 1];
        } else if ((front + position) < data.length) { // wrapping - before wrap
            return data[front + position - 1];
        } else { // wrapping - after wrap
            return data[position - (front + data.length) - 1];
        }
    }
}
