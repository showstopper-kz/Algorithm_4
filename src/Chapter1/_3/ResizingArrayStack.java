package Chapter1._3;

import java.util.Iterator;
import java.util.Scanner;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int N;
    private Item[] a;

    private class ReverseIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public ResizingArrayStack(int n) {
        N = 0;
        a = (Item[]) new Object[n];
    }

    public Item pop() {
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return a[--N];
    }

    public void push(Item s) {
        if (N == a.length) resize(N * 2);
        a[N++] = s;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int size) {
        Item[] arr = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            arr[i] = a[i];
        }
        a = arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(10);

        while (!sc.hasNext("quit")) {
            String s = sc.next();
            if (s.equals("-"))
                System.out.println(stack.pop());
            else stack.push(s);
        }

        for (String s : stack) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }
}
