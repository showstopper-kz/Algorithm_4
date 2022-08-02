package Chapter1._3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable{
    private int N;
    private Node first;

    private int pushOpCnt;
    private int popOpCnt;

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
        pushOpCnt = (pushOpCnt + 1) % 2;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item res = first.item;
        first = first.next;
        N--;
        popOpCnt = (popOpCnt + 1) % 2;
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

    public static void main(String[] args) throws Exception{
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i+"");
        }

        for (Object o : stack) {
            stack.push("s");
        }
    }
    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private int currentPushCnt = pushOpCnt;
        private int currentPopCnt = popOpCnt;

        @Override
        public boolean hasNext() {
            if (pushOpCnt != currentPushCnt || popOpCnt != currentPopCnt) {
                throw new ConcurrentModificationException("stack has been changed");
            }
            return current != null;
        }

        @Override
        public Item next() {
            if (pushOpCnt != currentPushCnt || popOpCnt != currentPopCnt) {
                throw new ConcurrentModificationException("stack has been changed");
            }
            Item res = current.item;
            current = current.next;
            return res;
        }
    }
}
