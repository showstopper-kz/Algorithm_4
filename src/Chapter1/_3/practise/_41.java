package Chapter1._3.practise;


import Chapter1._3.Queue;

public class _41 {
    public static void main(String[] args) {
        Queue<String> q1 = new Queue<>();
        q1.enqueue("a");
        q1.enqueue("b");
        q1.enqueue("c");
        Queue<String> q2 = new Queue<>(q1);

        q2.enqueue("d");
        q2.print();
        q1.print();

        q2.dequeue();
        q2.print();
        q1.print();
    }
}
