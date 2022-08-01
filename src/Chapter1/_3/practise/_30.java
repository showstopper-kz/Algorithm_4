package Chapter1._3.practise;

import Chapter1._3.Node;

public class _30 {
    public static Node reverseNode(Node list) {
        if (list == null) return null;

        Node cur = list;
        Node res = cur;
        cur = cur.next;
        res.next = null;

        while (cur != null) {
            Node node = cur;
            cur = cur.next;
            node.next = res;
            res = node;
        }
        return res;
    }

    public static Node reverseNodeReversed(Node list) {
/*
        if (list.next == null) return list;
        if (list.next.next == null) {
            Node node = list.next;
            node.next = list;
            list.next = null;
            return list;
        }
        Node node = reverseNodeReversed(list.next);
        node.next = list;
        list.next = null;
*/
        // return list;

        if (list == null) return null;
        if (list.next == null) return list;
        Node next = list.next;
        Node res = reverseNodeReversed(next);
        next.next = list;
        list.next = null;
        return res;
    }

    public static void main(String[] args) {
        Node<String> test = Node.generateTestNode(5);
        Node reversedNode = reverseNodeReversed(test);
        Node.printLinkedList(reversedNode);
    }
}
