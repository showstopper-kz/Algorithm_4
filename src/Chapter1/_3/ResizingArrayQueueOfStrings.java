package Chapter1._3;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ResizingArrayQueueOfStrings {
    private int N;
    private int first;
    private int last;

    private String[] a;

    public ResizingArrayQueueOfStrings(int n) {
        N = 0;
        first =  0;
        last = 0;
        a = new String[n];
    }

    public void enqueue(String item) {
        if (N == a.length) resize(N * 2);
        a[last] = item;
        last = (last + 1) % a.length;
        N++;
    }

    public String dequeue() {
        if (N == 0) throw new NoSuchElementException("Stack underflow");
        if (N < a.length / 4) resize(a.length / 2);
        String res = a[first];
        first = (first + 1) % a.length;
        N--;
        return res;
    }

    private void resize(int size) {
        String[] temp = new String[size];
        int j = 0;
        if (first < last) {
            for(int i = first; i < last;i++) {
                temp[j++] = a[i];
            }
        } else {
            for (int i = first; i < a.length; i++)
                temp[j++] = a[i];
            for (int i = 0; i < last; i++)
                temp[j++] = a[i];
        }

        a = temp;
        first = 0;
        last = j;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(3);
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("quit")) {
            String s = sc.next();
            if (s.equals("-"))
                System.out.println(queue.dequeue());
            else
                queue.enqueue(s);
        }
    }
}
