package Chapter1._3;

import java.util.Arrays;
import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item>{
    private Item[] arr;
    private int index;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public RandomBag(int n) {
        arr = (Item[]) new Object[n];
        index = 0;
        N = 0;
    }

    private void resize(int n) {
        Item[] newArr = (Item[]) new Object[n];
        for (int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        index = N-1;
    }

    public void add(Item item) {
        if (item == null) return;
        /*
        if (index == arr.length - 1)
            resize(arr.length * 2);
         */

        if (N == 0) {
            arr[index] = item;
        } else {
            int newIndex = index + 1;
            arr[newIndex] = item;
            index = newIndex;
        }
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagRandomIterator<Item>();
    }

    private class BagRandomIterator<Item> implements Iterator<Item> {
        Item[] randomedArr ;
        int count;

        public BagRandomIterator() {
            randomedArr = (Item[]) Arrays.copyOf(arr, arr.length);
            count = randomedArr.length;
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Item next() {
            int i = (int) (Math.random() * count);
            Item res = randomedArr[i];
            randomedArr[i] = randomedArr[count - 1];
            randomedArr[count - 1] = null;
            count-- ;
            return res;
        }
    }

    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<>(4);
        bag.add("1");
        bag.add("2");
        bag.add("3");
        bag.add("4");
        for (String s : bag) {
            System.out.println(s);
        }
    }
}

