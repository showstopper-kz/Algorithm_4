package Chapter1._2.practise;

import Chapter1._2.Date;
import Chapter1._3.Queue;

import java.util.Scanner;

public class TransAction implements Comparable<TransAction> {
    String who;
    Date when;
    double amount;

    public TransAction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public TransAction(String transAction) throws Exception {
        String[] fileds = transAction.split(" ");
        this.who = fileds[0];
        this.when = new Date(fileds[1]);
        this.amount = Double.parseDouble(fileds[2]);
    }

    @Override
    public String toString() {
        return who+" trans "+ amount + " at " + when.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        TransAction that = (TransAction)obj;

        if (this.who == that.who && this.when == that.when && this.amount == that.amount)
            return true;
        else
            return false;
    }

    public int compareTo(TransAction that) {
        return (int)(this.amount - that.amount);
    }

    public static TransAction[] readTransActions(Scanner sc) throws Exception {
        Queue<String[]> queue = new Queue<>();
        while (!sc.hasNext("quit")) {
            String s = sc.nextLine();
            String[] sArr = s.split("[ ,\n]");
            queue.enqueue(sArr);
        }
        
        int size = queue.size();
        TransAction[] transActions = new TransAction[size];
        for (int i = 0; i < size; i++) {
            String[] sArr = queue.dequeue();
            String who = sArr[0];
            String dateS = sArr[1];
            String[] dateArr = dateS.split("/");
            Date when = new Date(Integer.parseInt(dateArr[0]),
                                 Integer.parseInt(dateArr[1]),
                                 Integer.parseInt(dateArr[2]));
            double amount = Double.parseDouble(sArr[2]);
            transActions[i] = new TransAction(who, when, amount);
        }
        return transActions;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        TransAction[] transActions = TransAction.readTransActions(sc);
        for (TransAction transAction : transActions) {
            System.out.println(transAction.toString());
        }
    }
}
