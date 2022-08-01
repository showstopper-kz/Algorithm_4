package Chapter1._3;

import edu.princeton.cs.algs4.StdRandom;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int last;
    private int N;

    public RandomQueue(int n) {
        arr = (Item[]) new Object[n];
        last = -1;
        N = 0;
    }

    private void resize(int n) {
        Item[] newArr = (Item[]) new Object[n];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void enqueue(Item item) {
        if (item == null) return;

        if (N == arr.length) resize(N * 2);
        last = last + 1;
        arr[last] = item;
        N++;
    }

    public Item dequeue() throws OperationNotSupportedException {
        if (N == 0)
            throw new OperationNotSupportedException("list is empty");

        if (N == arr.length / 4) resize(arr.length / 2);
        int index = StdRandom.uniform(N);
        Item res = arr[index];
        arr[index] = arr[last];
        arr[last] = null;
        last = last - 1;
        N--;
        return res;
    }

    public Item sample() throws OperationNotSupportedException {
        if (N == 0)
            throw new OperationNotSupportedException("list is empty");

        int res = StdRandom.uniform(N);
        return arr[res];
    }

    public Iterator<Item> iterator() {
        return new RandomQueueIterator<>();
    }

    private class RandomQueueIterator<Item> implements Iterator<Item> {
        private Item[] iterArr ;
        private int count;

        public RandomQueueIterator() {
            iterArr =  (Item[]) arr;
            count = N;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            int index = StdRandom.uniform(count);
            Item res = iterArr[index];
            iterArr[index] = iterArr[count - 1];
            iterArr[count - 1] = null;
            count--;
            return res;
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        RandomQueue<String> queue = new RandomQueue<>(2);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
