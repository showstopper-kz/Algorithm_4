package Chapter1._1.practise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class _36 {
    public static void main(String[] args) {
        int[][] res = shuffleTest(10, 1000000);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] shuffleTest(int M, int N) {
        int[] testArr = new int[M];
        int[][] res = new int[M][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < testArr.length; j++) {
                testArr[j] = j;
            }

            StdRandom.shuffle(testArr);

            for (int j = 0; j < testArr.length; j++) {
                res[testArr[j]][j]++;
            }
        }

        return res;
    }
}
