package Chapter1._3;

public class Steque<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public Steque() {
        first = last = null;
        N = 0;
    }

    public void push(Item item) {
        if (item == null) return;

        Node iNode = new Node<>(item);
        if (N == 0) {
            first = last = iNode;
        } else {
            iNode.next = first;
            first = iNode;
        }
        N++;
    }

    public Item pop() {
        if (N == 0) {
            throw new NullPointerException("list is empty");
        } else {
            Node<Item> node = first;
            first = first.next;
            node.next = null;
            N--;
            return node.item;
        }
    }

    public void enqueue(Item item) {
        if (item == null) return;

        Node<Item> node = new Node<>(item);
        if (N == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    public static void main(String[] args) {
        Steque<String> queue = new Steque<>();
        queue.push("1");
        queue.push("2");
        queue.enqueue("3");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
