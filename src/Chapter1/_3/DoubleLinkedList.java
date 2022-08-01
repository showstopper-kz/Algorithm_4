package Chapter1._3;

public class DoubleLinkedList<Item> {
    private class DoubleNode<Item> {
        DoubleNode<Item> prev;
        Item item;
        DoubleNode<Item> next;

        public DoubleNode(Item item) {
            this.item = item;
        }
    }

    // if list has only one item, then first = last
    private DoubleNode<Item> first;
    private DoubleNode<Item> last;
    private int N;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        N = 0;
    }

    /**
     * if list is empty, will init the list and let last = first
     * @param item
     */
    public void insertBeforeFirst(Item item) {
        if (item == null) return;

        DoubleNode<Item> node = new DoubleNode<>(item);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    /**
     * if list is empty, will init the list and let first = last
     * @param item
     */
    public void insertAfterLast(Item item) {
        if (item == null) return;

        DoubleNode<Item> node = new DoubleNode<>(item);
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        N++;
    }
    public void insertBeforeNode(DoubleNode<Item> index, Item item) {
        if (index == null || item == null) return;

        if (index == first) {
            insertBeforeFirst(item);
        } else {
            DoubleNode<Item> node = new DoubleNode<>(item);
            index.prev.next = node;
            node.prev = index.prev;
            node.next = index;
            index.prev = node;
        }
        N++;
    }

    public void insertAfterNode(DoubleNode<Item> index, Item item) {
        if (index == null || item == null) return;

        if (index == last) {
            insertAfterLast(item);
        } else {
            DoubleNode<Item> node = new DoubleNode<>(item);
            node.next = index.next;
            node.next.prev = node;
            node.prev = index;
            index.next = node;
        }
        N++;
    }

    public void deleteNode(DoubleNode<Item> node) {
        if (node == null) return;
        if (N == 0)
            throw new NullPointerException("Empty list");
        else if (first == node) {
            deleteFirst();
        } else if (last == node) {
            deleteLast();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            N--;
        }
    }

    public void deleteFirst() {
        if (first == null)
            throw new NullPointerException("empty list");
        else if (first == last) {
            first = last = null;
        } else {
            DoubleNode<Item> node = first;
            first = first.next;
            first.prev = null;
            node.next = null;
        }
        N--;
    }

    public void deleteLast() {
        if (last == null)
            throw new NullPointerException("empty list");
        else if (last == first) {
            first = last = null;
        } else {
            DoubleNode<Item> node = last;
            last = last.prev;
            last.next = null;
            node.prev = null;
        }
        N--;
    }

    public void printList() {
        if (first == null) {
            System.out.println("empty list");
        } else {
            DoubleNode<Item> cur = first;
            System.out.print(cur.item);
            cur = cur.next;
            while (cur != null) {
                System.out.print(" -> " + cur.item);
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insertBeforeFirst("3");
        list.insertBeforeFirst("1");
        list.insertBeforeNode(list.first.next, "2");
        list.insertAfterNode(list.first.next.next, "3");
        list.insertAfterLast("5");
        list.insertAfterNode(list.last, "6");
        list.printList();

        list.deleteNode(list.first.next);
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();
    }
}
