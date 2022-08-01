package Chapter1._3.practise;

import Chapter1._3.Node;

public class _24 {
    public static void removeAfter(Node<String> node) {
        if (node == null || node.next == null) return;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        Node<String> test = Node.generateTestNode(5);
        removeAfter(test.next);
        Node.printLinkedList(test);
    }
}
