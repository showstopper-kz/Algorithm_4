package Chapter1._3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable{
    private int N;
    private Node first;

    public Stack() {
        N = 0;
        first = null;
    }

    public Stack(Stack<Item> stack) {
        if (stack.N == 0) {
            return;
        } else if(stack.N == 1){
            first = new Node(stack.first.item);
        } else {
            first = new Node(stack.first.item);
            Node thatCur = stack.first.next;
            Node preCur = first;
            while (thatCur != null) {
                Node node = new Node(thatCur.item);
                preCur.next = node;
                preCur = preCur.next;
                thatCur = thatCur.next;
            }
        }
        N = stack.N;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getN() {
        return N;
    }

    public Node getFirst() {
        return first;
    }

    public int size() {return N;}

    public boolean isEmpty() {return N == 0;}
    class Node {
        Item item;
        Node next;
        public Node(Item item) {
            this.item = item;
        }
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item res = first.item;
        first = first.next;
        N--;
        return res;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public void print() {
        if (N == 0) return;
        else if (N == 1) {
            System.out.println(first.item);
        } else {
            System.out.print(first.item);
            Node cur = first.next;
            while (cur != null) {
                System.out.print(" -> " + cur.item);
                cur = cur.next;
            }
            System.out.println();
        }
    }
    @Override
    public Iterator iterator() {
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
