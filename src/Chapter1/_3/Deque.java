package Chapter1._3;

public class Deque<Item> {
    private class DoubleNode<Item> {
        DoubleNode<Item> prev;
        Item item;
        DoubleNode<Item> next;

        public DoubleNode(Item item) {
            this.item = item;
        }
    }

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;
    private int N;

    public Deque() {
        first = last = null;
        N = 0;
    }

    public Deque(Item item) {
        pushLeft(item);
    }

    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}

    public void pushLeft(Item item) {
        if (item == null) return;
        DoubleNode<Item> node = new DoubleNode<>(item);
        if (N == 0) {
            first = last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    public void pushRight(Item item) {
        if (item == null) return;
        DoubleNode<Item> node = new DoubleNode<>(item);
        if (N == 0) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        N++;
    }

    public Item popLeft() {
        if (N == 0) {
            throw new NullPointerException("Empty list");
        } else if (N == 1) {
            Item res = first.item;
            first = last = null;
            N--;
            return res;
        } else {
            DoubleNode<Item> preFirst = first;
            first = first.next;
            preFirst.next = null;
            N--;
            return preFirst.item;
        }
    }

    public Item popRight() {
        if (N == 0) {
            throw new NullPointerException("Empty list");
        } else if (N == 1) {
            Item res = first.item;
            first = last = null;
            N--;
            return res;
        } else {
            DoubleNode<Item> preLast = last;
            last = last.prev;
            preLast.prev = null;
            N--;
            return preLast.item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushLeft("1");
        deque.pushRight("2");
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
    }
}
