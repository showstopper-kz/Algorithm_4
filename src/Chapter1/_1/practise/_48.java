package Chapter1._1.practise;

import Chapter1._3.Deque;

import javax.naming.OperationNotSupportedException;

public class _48<Item> {
    private Deque<Item> deque;
    private int leftStackSize;
    private int rightStackSize;

    public _48() {
        deque = new Deque<>();
        leftStackSize = rightStackSize = 0;
    }

    public int leftStackSize() { return leftStackSize;}
    public int rightStackSize() { return rightStackSize;}

    public void pushLeft(Item item) {
        deque.pushLeft(item);
        leftStackSize++;
    }

    public Item popLeft() throws OperationNotSupportedException {
        if (leftStackSize > 0) {
            Item item = deque.popLeft();
            leftStackSize--;
            return item;
        } else {
            throw new OperationNotSupportedException("left stack is empty");
        }
    }

    public void pushRight(Item item) {
        deque.pushRight(item);
        rightStackSize++;
    }

    public Item popRight() throws OperationNotSupportedException {
        if (rightStackSize > 0) {
            Item item = deque.popRight();
            rightStackSize--;
            return item;
        } else {
            throw new OperationNotSupportedException("Right stack is empty");
        }
    }

    public static void main(String[] args) throws Exception{
        _48<String> test = new _48<>();
        test.pushLeft("1");
        test.pushLeft("2");
        System.out.println(test.leftStackSize);
        test.popLeft();
        test.popLeft();
        test.popLeft();

        test.pushRight("1");
        test.pushRight("2");
        System.out.println(test.rightStackSize);
        test.popRight();
        test.popRight();
        test.popRight();
    }
}
