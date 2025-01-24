package net.mcribbs.ds;

public interface Stack<T> {
    void push(T item);
    T pop();
    boolean contains(T item);
    T access(T item);
    int size();
}
