package Chapter1._3.practise;

import Chapter1._3.RandomQueue;

import javax.naming.OperationNotSupportedException;

public class _35 {
    private class Card{
        String value;

        public Card(String value) {
            this.value = value;
        }
    }

    public Card[][] divideCard() throws OperationNotSupportedException {
        Card[][] res = new Card[4][13];
        RandomQueue<Card> queue = new RandomQueue<>(52);
        for (int i = 0; i < 4; i++) {
            queue.enqueue(new Card("A"));
            for (int j = 2; j <= 10; j++) {
                queue.enqueue(new Card(j+""));
            }
            queue.enqueue(new Card("J"));
            queue.enqueue(new Card("Q"));
            queue.enqueue(new Card("K"));
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                res[i][j] = queue.dequeue();
            }
        }
        return res;
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        Card[][] res = new _35().divideCard();
        for (int i = 0; i < 4; i++) {
            for (Card card : res[i]) {
                System.out.print(card.value.equals("10") ?  card.value + " ": card.value + "  ");
            }
            System.out.println();
        }
    }
}
