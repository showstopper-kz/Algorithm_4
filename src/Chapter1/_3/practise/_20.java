package Chapter1._3.practise;

import Chapter1._3.Node;

public class _20 {
    public static boolean delKNode(int k, Node<String> start) throws Exception {
        if (k < 0)
            throw new Exception("k should be equal or larger than 0");
        if (k == 0) return true;

        int count = 1;
        Node<String> cur = start;
        for (int i = 1; i < k - 1; i++) {
            if (cur == null) throw new Exception("this linked list has smaller items than k");
            cur = cur.next;
        }
        if (cur.next == null) throw new Exception("this linked list has smaller items than k");
        cur.next = cur.next.next;
        return true;
    }

    public static void main(String[] args) throws Exception {
        Node<String> list = Node.generateTestNode(5);
        Node.printLinkedList(list);
        delKNode(3,list);
        Node.printLinkedList(list);
    }
}
