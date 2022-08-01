package Chapter1._3.practise;

import Chapter1._3.Node;

public class _29 {
    public static void main(String[] args) throws Exception {
        NodeQueue<String> queue = new NodeQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}

class NodeQueue<Item> {
    Node<Item>  last;

    public void enqueue(Item item) {
        if (last == null) {
            last = new Node<>(item);
            last.next = last;
            return ;
        } else {
            Node<Item> node = new Node<>(item);
            node.next = last.next;
            last.next = node;
            last = node;
        }
    }

    public Item dequeue() throws Exception {
        if (last == null) throw new Exception("queue is empty");
        if (last.next == last) {
            Item res = (Item) last.item;
            last = null;
            return  res;
        }

        Item res = (Item) last.next.item;
        last.next = last.next.next;
        return res;
    }

    public void printQueue() {
        Node<Item> cur = last.next;

        while (cur != last) {
            System.out.print(cur.item + " -> ");
            cur = cur.next;
        }
        System.out.print(last.item);
        System.out.println();
    }
}
