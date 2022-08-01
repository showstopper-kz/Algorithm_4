package Chapter1._1.practise;
import java.util.Arrays;

public class _13 {

    private static void swap(int[][] a, int rowIndex, int colIndex){
        int n = a[rowIndex][colIndex];
        a[rowIndex][colIndex] = a[colIndex][rowIndex];
        a[colIndex][rowIndex] = n;
    }

    private static void T(int [][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[0].length; j++) {
                swap(a, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        T(a);
        System.out.println(Arrays.deepToString(a));
    }
}
