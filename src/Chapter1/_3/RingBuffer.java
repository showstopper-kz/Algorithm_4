package Chapter1._3;
import javax.naming.OperationNotSupportedException;

public class RingBuffer<Item> {
    private int N;
    private Item[] arr;
    private int first;
    private int last;

    public RingBuffer(int size) {
        arr = (Item[]) new Object[size];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() { return N == 0;}
    public boolean isFull() {return N == arr.length;}

    public void enqueue(Item item) throws OperationNotSupportedException{
        if (isEmpty()) {
            arr[first] = item;
            last = first;
        } else if (isFull()){
            throw new OperationNotSupportedException("Queue is full");
        } else {
            last = (last + 1) % arr.length;
            arr[last] = item;
        }
        N++;
    }

    public Item dequeue() throws OperationNotSupportedException{
        if (isEmpty()) {
            throw new OperationNotSupportedException("Queue is Empty");
        } else {
            Item res = arr[last];
            last = last - 1 < 0 ? arr.length - 1: last - 1;
            N--;
            return res;
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException{
        RingBuffer<String> buffer = new RingBuffer<>(3);
        for (int i = 0; i < 3; i++) {
            buffer.enqueue(""+i);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(buffer.dequeue());
        }
    }
}
