package net.mcribbs.ds;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    private int capacity = 10;
    private int size;
    private T[] data;

    public MinHeap() {
        data = (T[]) new Comparable[capacity];
        size = 0;
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException("Heap empty");
        return data[0];
    }

    public T poll() {
        if (size == 0) throw new IllegalStateException("Heap empty");
        T item = data[0];
        T temp = data[size-1];
        data[size-1] = null;
        data[0] = temp;
        size--;
        siftDown();
        return item;
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
        siftUp();
    }

    private void siftDown() {
        int i = 0;
        while ((hasLeft(i) && data[i].compareTo(getLeftChild(i)) < 0)
                || (hasRight(i) && data[i].compareTo(getRightChild(i)) < 0)) {
            if (hasLeft(i) && data[i].compareTo(getLeftChild(i)) < 0) {
                swap(i, leftId(i));
                i = leftId(i);
            }
            if (hasRight(i) && data[i].compareTo(getRightChild(i)) < 0) {
                swap(i, rightId(i));
                i = rightId(i);
            }
        }
    }

    private void siftUp() {
        int i = size - 1;
        while (hasParent(i) && data[i].compareTo(getParent(i)) > 0) {
            swap(i, parentId(i));
            i = parentId(i);
        }
    }

    private void swap(int a, int b) {
        T temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity*2);
            capacity *= 2;
        }
    }

    private int leftId(int id) {
        return 2*id+1;
    }

    private int rightId(int id) {
        return 2*id+2;
    }

    private int parentId(int id) {
        return (id-1)/2;
    }

    private boolean hasLeft(int index) {
        return leftId(index) < size;
    }

    private boolean hasRight(int index) {
        return rightId(index) < size;
    }

    private boolean hasParent(int index) {
        return parentId(index) >= 0;
    }

    private T getLeftChild(int index) {
        return data[leftId(index)];
    }

    private T getRightChild(int index) {
        return data[rightId(index)];
    }

    private T getParent(int index) {
        return data[parentId(index)];
    }
}
