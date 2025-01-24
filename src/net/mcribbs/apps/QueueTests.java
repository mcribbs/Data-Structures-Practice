package net.mcribbs.apps;

import net.mcribbs.ds.BasicQueue;

public class QueueTests {

    public static void main(String[] args) {
        BasicQueue<Integer> q = new BasicQueue<Integer>();
        Integer retVal = null;
        boolean found;

        found = q.contains(3);
        q.enQueue(1);
        q.enQueue(2);
        try {
            retVal = q.access(4);
        } catch (Exception e) {
            System.out.println(e);
        }
        retVal = q.access(2);
        q.enQueue(3);
        found = q.contains(5);
        found = q.contains(3);
        q.enQueue(4);
        q.enQueue(5);
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        found = q.contains(5);
        q.enQueue(6);
        retVal = q.access(2);
        q.enQueue(7);
        q.enQueue(8);
        q.enQueue(9);
        q.enQueue(10);
        q.enQueue(11);
        q.enQueue(12);
        retVal = q.access(4);
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        retVal = q.deQueue();
        try {
            retVal = q.deQueue();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
