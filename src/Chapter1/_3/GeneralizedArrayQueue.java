package Chapter1._3;

import javax.naming.OperationNotSupportedException;

public class GeneralizedArrayQueue<Item> {
    private Item[] arr;
    private int N;
    private int first, last;

    public boolean isEmpty() {return N == 0;}
    public GeneralizedArrayQueue(int size) {
        this.arr = (Item[]) new Object[size];
        first = last = 0;
    }

    public void insert(Item item) {
        if (N == 0) {
            arr[first] = item; 
            last = first;
        } else {
            if (N == arr.length) {resize(N * 2);}
            last++;
            arr[last] = item;
        }
        N++;
    }

    public void resize(int size) {
        Item[] newArr = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[(first + i) % arr.length];
        }
        this.arr = newArr;
        first = 0;
        last = N-1;
    }

    public Item delete(int k) throws OperationNotSupportedException {
        if (N < k)
            throw new OperationNotSupportedException("Queue is empty");
        else if (N == 1) {
            N--;
            return arr[first];
        } else {
            int index = (first + k -1) % arr.length;
            Item res = arr[index];
            for (int i = index; i < last; i++) {
                arr[i] = arr[(i+1) % arr.length];
            }
            arr[last] = null;
            last = (last - 1) < 0 ? arr.length - 1 : last - 1;
            N--;
            if (N == arr.length / 4) resize(arr.length / 2);
            return res;
        }
    }

    public static void main(String[] args) throws Exception{
        GeneralizedArrayQueue<String> queue = new GeneralizedArrayQueue<>(2);
        queue.insert("1");
        queue.insert("2");
        queue.insert("3");
        queue.insert("4");
        System.out.println(queue.delete(4));
        System.out.println(queue.delete(3));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(1));
    }
}
