package Chapter1._3;

public class Node<Item> {
    public Item item;
    public Node next;

    public Node(Item item) {
        this.item = item;
    }

    /**
     *
     * @param k at least >= 1
     * @return
     */
    public static Node<String> generateTestNode(int k) {
        Node<String> start = new Node<>("1");
        Node<String> cur = start;
        for (int i = 1; i < k; i++) {
            cur.next = new Node(""+ (i+1));
            cur = cur.next;
        }
        return start;
    }

    public static void printLinkedList(Node<String> start) {
        if (start == null) return;
        Node<String> cur = start;
        System.out.print(cur.item);
        cur = cur.next;
        while (cur != null) {
            System.out.printf(" -> " + cur.item);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<String> list = Node.generateTestNode(5);
        Node.printLinkedList(list);
    }
}
