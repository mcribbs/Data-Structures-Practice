package net.mcribbs.apps;

import net.mcribbs.ds.MinHeap;

public class TestMinHeap {

    public static void main(String[] args) {
        MinHeap<String> heap = new MinHeap<String>();

        heap.add("A");
        heap.add("B");
        heap.add("Q");
        heap.add("D");
        heap.add("E");
        String t = heap.peek();
        t = heap.poll();
        t = heap.poll();
        t = heap.poll();
        heap.add("G");
        heap.add("I");
        heap.add("A");
        t = heap.poll();
    }
}
