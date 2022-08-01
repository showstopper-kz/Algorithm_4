package Chapter1._3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node current;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Bag() {}

    public int size() {return N;}

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(Item item) {
        Node oldCurrent = current;
        Node current = new Node();
        current.item = item;
        current.next = oldCurrent;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = Bag.this.current;

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
