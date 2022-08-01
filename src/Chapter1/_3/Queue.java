package Chapter1._3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;
    private class Node {
        Item item;
        Node next;
    }

    public Queue() {
        N = 0;
        first = last = null;
    }

    public Queue(Queue<Item> q) {
        for (Item item : q) {
            enqueue(item);
        }
    }

    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        Node lastOld = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else lastOld.next = last;
        N++;
    }

    public Item dequeue() {
        Node oldFirst = first;
        first = oldFirst.next;
        N--;
        if (isEmpty()) last = first;
        return oldFirst.item;
    }

    public void catenation(Queue<Item> desQue) {
        this.last.next = desQue.first;
        N += desQue.size();
        last = desQue.last;
    }

    public void print() {
        if (N == 0) return;
        else if (N == 1)
            System.out.println(first.item);
        else {
            System.out.print(first.item);
            Node cur = first.next;
            while (cur.next != null) {
                System.out.print(" -> " + cur.item);
                cur = cur.next;
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item res = current.item;
            current = current.next;
            return res;
        }
    }
}
