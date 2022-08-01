package Chapter1._3;

import javax.naming.OperationNotSupportedException;

public class GeneralizedQueue<Item> {
    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private int N;
    private Node first;
    private Node last;

    public boolean isEmpty() {return N == 0;}

    public GeneralizedQueue() {
        first = last = null;
        N = 0;
    }

    public void insert(Item item) {
        if (N == 0) {
            first = last = new Node(item);
        } else {
            Node newLast = new Node(item);
            last.next = newLast;
            last = newLast;
        }
        N++;
    }

    public Item delete(int k) throws OperationNotSupportedException{
        if (N < k)
            throw new OperationNotSupportedException("This queue has less elements than" + k);
        else if (N == 1) {
            Item res = first.item;
            N--;
            first = last = null;
            return res;
        } else {
            Node i = first;
            int cnt = 1;
            for (; i != null; i = i.next) {
                if (cnt == k - 1) break;
                cnt++;
            }

            Node res = i.next;
            i.next = res.next;
            res.next = null;
            N--;
            return res.item;
        }
    }

    public static void main(String[] args) throws Exception{
        GeneralizedQueue<String> queue = new GeneralizedQueue<>();
        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        System.out.println(queue.delete(4));
        System.out.println(queue.delete(3));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(1));
    }
}
