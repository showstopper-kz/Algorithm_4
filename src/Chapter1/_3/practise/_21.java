package Chapter1._3.practise;

import Chapter1._3.Node;

public class _21 {
    public static boolean findItemAtList(Node<String> list, String k) throws Exception{
        Node<String> cur = list;
        if (list == null) throw new NullPointerException("list is null");
        if (k == null) throw new NullPointerException("k is null");
        while (cur != null) {
            if (cur.item.equals(k)) return true;
            cur = cur.next;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        Node<String> test = Node.generateTestNode(5);
        System.out.println(findItemAtList(test, "3"));
        System.out.println(findItemAtList(test,"8"));
    }
}
