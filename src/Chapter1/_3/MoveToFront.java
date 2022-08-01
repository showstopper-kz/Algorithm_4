package Chapter1._3;

import java.util.Scanner;

public class MoveToFront {
    public static void main(String[] args) {
        CustomStack<String> stack = new CustomStack<>();
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("quit")) {
            char[] sArr = sc.next().toCharArray();
            for (char c : sArr) {
                stack.push(c+"");
            }

            for (Object o : stack) {
                System.out.print(o + "->");
            }
            System.out.println();
        }
    }
}

class CustomStack<Item> extends Stack<Item> {
    public CustomStack() {
        super();
    }

    @Override
    public void push(Item item) {
        if (super.getN() == 0) {
            super.push(item);
        } else if (super.getN() == 1 && super.getFirst().item.equals(item)){
            return;
        } else{
            Node cur = super.getFirst();
            Node preCur = cur;
            while (cur.next != null) {
                if (cur.item.equals(item)) {
                    break;
                }
                preCur = cur;
                cur = cur.next;
            }
            if (cur.item.equals(item)) {
                Node node = cur;
                preCur.next = cur.next;
                cur.next = super.getFirst();
                super.push(item);
            } else {
                super.push(item);
            }
        }
    }
}
