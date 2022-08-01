package Chapter1._3;

import javax.naming.OperationNotSupportedException;

public class Buffer {
    private Stack<Character> left;
    private Stack<Character> right;

    public Buffer() {
        left = new Stack<Character>();
        right = new Stack<Character>();
    }

    public void insert(char c) {
        left.push(c);
    }

    public char delete() {
        return left.pop();
    }

    public void left(int k) throws OperationNotSupportedException{
        if (k < 0) return;
        else if (k > left.size())
            throw new OperationNotSupportedException("there's not enough space rightsize");
        else {
            for (int i = 0; i < k; i++) {
                right.push(left.pop());
            }
        }
    }

    public void right(int k) throws OperationNotSupportedException{
        if (k < 0) return ;
        else if (k > right.size())
            throw new OperationNotSupportedException("there's not enough space rightsize");
        else {
            for (int i = 0; i < k; i++) {
                left.push(right.pop());
            }
        }
    }

    public int size() {
        return left.size() + right.size();
    }

    public void print() {
        System.out.println("pos: " + left.size());
    }
    public static void main(String[] args) throws OperationNotSupportedException{
        Buffer buffer = new Buffer();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.print();

        buffer.left(2);
        buffer.print();

        buffer.right(1);
        buffer.print();
    }
}
