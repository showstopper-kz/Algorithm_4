package Chapter1._3.practise;

import Chapter1._3.Bag;
import Chapter1._3.Node;

public class _19 {

    public static void deleteLastNode(Node<String> start) {
        Node<String> node = start;
        // pretend this linkedlist has more than one node
        Node<String> next = start.next;
        while (next.next != null) {
            node = next;
            next = next.next;
        }
        node.next = null;
    }

    public static void main(String[] args) {
        Node<String> list = Node.generateTestNode(5);
        Node.printLinkedList(list);
        deleteLastNode(list);
        Node.printLinkedList(list);
    }
}
