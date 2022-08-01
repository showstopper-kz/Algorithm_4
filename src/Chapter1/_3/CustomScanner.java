package Chapter1._3;
import edu.princeton.cs.algs4.Queue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CustomScanner {
    public static void main(String[] args) throws Exception{
        int[] arr = readAllInts("/Users/zhuyongqi/test.txt");
        System.out.println(Arrays.toString(arr));
    }

    private static int[] readAllInts(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);

        Scanner sc = new Scanner(fileInputStream);
        Queue<Integer> queue = new Queue<>();
        while (sc.hasNextInt())
            queue.enqueue(sc.nextInt());

        int N = queue.size();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = queue.dequeue();
        }
        return res;
    }
}
