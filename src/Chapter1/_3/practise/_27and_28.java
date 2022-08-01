package Chapter1._3.practise;


import Chapter1._3.Node;

public class _27and_28 {
    public static int max(Node<String> list) {
        Node<String> cur = list;
        int max = Integer.MIN_VALUE;
        while (cur != null) {
            int a = Integer.parseInt(cur.item);
            if (a > max) max = a;
            cur = cur.next;
        }
        return max;
    }

    public static int maxReverse(Node<String> list, int k) {
        if (list == null) return k;
        int a = Integer.parseInt(list.item);
        a = a > k ? a : k;
        return maxReverse(list.next, a);
    }

    public static void main(String[] args) {
        Node<String> test = Node.generateTestNode(5);
        System.out.println(max(test));
        System.out.println(maxReverse(test, Integer.MIN_VALUE));
    }
}
