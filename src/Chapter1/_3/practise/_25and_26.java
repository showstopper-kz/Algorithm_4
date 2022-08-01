package Chapter1._3.practise;

import Chapter1._3.Node;

import javax.jnlp.ClipboardService;

public class _25and_26 {
    public static void insertAfter(Node<String> node1, Node<String> node2) {
        if (node1 == null || node2 == null)
            return ;

        node2.next = node1.next;
        node1.next = node2;
    }

    public static void remove(Node<String> list, String key) {
        if (list == null || key == null) return;

        Node<String> cur = list;
        Node<String> pre = null;
        while (cur != null) {
            if (cur.item.equals(key)) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node<String> test = Node.generateTestNode(5);
        Node<String> node = new Node<>("5");
        insertAfter(test, node);
        Node.printLinkedList(test);
        remove(test, "5");
        Node.printLinkedList(test);
    }
}
