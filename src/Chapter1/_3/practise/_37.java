package Chapter1._3.practise;

import Chapter1._3.Queue;

import java.util.Scanner;

public class _37 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            count ++;
            int item = queue.dequeue();

            if (count == M) {
                System.out.print(item + " ");
                // forget to reset count
                count = 0;
            } else {
                queue.enqueue(item);
            }
        }
        System.out.println(queue.dequeue());
    }
}
