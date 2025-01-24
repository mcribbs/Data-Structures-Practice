package net.mcribbs.ds;

public interface BinaryTree<T extends Comparable<T>> {
   int size();
   void add(T item);
   boolean contains(T item);
   boolean delete(T item);
}

