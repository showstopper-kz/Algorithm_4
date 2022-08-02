package Chapter1._1.practise;

import Chapter1._3.Stack;

import javax.naming.OperationNotSupportedException;

public class _49<Item> {
    Stack<Item> stack1 = new Stack<>();
    Stack<Item> stack2 = new Stack<>();

    public int size() {return stack1.size() + stack2.size();}

    public void enqueue(Item item) {
        stack1.push(item);
    }

    public Item deque() throws OperationNotSupportedException {
        if (size() > 0) {
            if (stack2.size() > 0) {
                return stack2.pop();
            } else if ( stack1.size() == 1) {
                return stack1.pop();
            } else {
                for (Object o : stack1) {
                    stack2.push((Item) o);
                }
                return stack2.pop();
            }
        } else {
            throw new OperationNotSupportedException("queue is empty");
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException{
        _49<String> queue = new _49<>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i+"");
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(queue.deque() + " ");
        }
    }
}
