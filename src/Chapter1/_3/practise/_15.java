package Chapter1._3.practise;

import Chapter1._3.Queue;
import Chapter1._3.Stack;
import netscape.security.UserTarget;

import java.util.Scanner;

public class _15 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        while (!scanner.hasNext("quit")) {
            queue.enqueue(scanner.next());
        }

        for (int i = 0; i < queue.size() - k + 1; i++) {
            queue.dequeue();
        }

        System.out.println(queue.dequeue());
    }
}
