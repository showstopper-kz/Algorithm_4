package Chapter1._1.practise;
import java.util.Scanner;

public class _21 {
    public static void main(String[] args) {
        String[] nameArr = new String[1000];
        double[][] scoreArr = new double[1000][3];
        int i = 0;
        Scanner s = new Scanner(System.in);

        while (true) {
            String name = s.next();
            if (name.equals("q")) {
                break;
            }

            nameArr[i] = name;
            scoreArr[i][0] = s.nextInt();
            scoreArr[i][1] = s.nextInt();
            scoreArr[i][2] = scoreArr[i][0] / scoreArr[i][1];
            i++;
        }

        plotTable(nameArr, scoreArr, i);
    }

    public static void plotTable(String[] name, double[][] score, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.printf("%s %.0f %.0f %.3f", name[i], score[i][0], score[i][1], score[i][2]);
        }
    }
}

