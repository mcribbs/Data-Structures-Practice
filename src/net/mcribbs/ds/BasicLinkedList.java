package net.mcribbs.ds;

public class BasicLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public BasicLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T item) {
        if (head == null) { // empty list
           head = new Node(item);
           tail = head;
        } else {
            Node newNode = new Node(item);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void insert(T item, int position) {
        if (size() < position) {
            throw new IllegalStateException("Index out of bounds");
        }

        Node current = head;
        for (int i = 1; i < position && current != null; i++) {
           current = current.getNext();
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public T removeAt(int position) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (size() < position) {
            throw new IllegalStateException("Index out of bounds");
        }

        if (size() == 1) { // list of one
            return remove();
        }

        Node previous = head;
        Node current = head.getNext();
        for (int i = 2; i <= position - 1 && current != null; i++) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
        size--;
        return current.getItem();
    }

    public T remove() {
        if (head == null) { //empty list
            throw new IllegalStateException("Empty");
        }

        Node retVal = head;
        head = head.getNext();
        size--;
        return retVal.getItem();
    }

    public T get(int position) {
        if (size() < position) {
            throw new IllegalStateException("Index out of bounds");
        }
        if (head == null) { //empty list
            throw new IllegalStateException("Empty");
        }

        Node current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.getNext();
        }
        return current.getItem();
    }

    public int find(T item) {
        if (head == null) { //empty list
            throw new IllegalStateException("Empty");
        }

        Node current = head;
        for (int i = 1; i < size() && current != null; i++) {
            if (item.equals(current.getItem())) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public String toString() {
        StringBuilder contents = new StringBuilder();

        Node current = head;
        while (current != null) {
            contents.append(current.getItem());
            current = current.getNext();
            if (current != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    private class Node {
        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
            next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getItem() {
            return item;
        }
    }
}
