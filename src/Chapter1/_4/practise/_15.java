package Chapter1._4.practise;

import Chapter1._4.ThreeSumFast;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Timer;

public class _15 {
    public static int twoSumFaster(String filePath) {
        int res = 0;
        int[] a = In.readInts(filePath);
        Arrays.sort(a);
        int i =0, j = a.length - 1;
        int len = a.length;
        while (i < len && i < j) {
            if (a[i] + a[j] == 0) {
                res++;
                j--;
                i++;
            } else {
                if (a[j] > -a[i])
                    j--;
                else i++;
            }
        }
        return res;
    }

    public static int threeSumFaster(String filePath) throws Exception{
        int[] a = In.readInts(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/res_faster_O(N).txt"));
        int res = 0;
        int len = a.length;
        int i, j;
        Arrays.sort(a);
        for (int k = 0; k < a.length; k++) {
            //reset status
            i = k + 1; j = a.length - 1;
            while (i < len && i < j) {
                int sum = a[k] + a[i] + a[j];
                if (sum == 0) {
                    fileOutputStream.write(String.format("a[%d]: %d; a[%d]: %d; a[%d]: %d\n",k, a[k], i, a[i], j, a[j]).getBytes());
                    res++;
                    i++;
                    j--;
                } else if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(threeSumFaster("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/2Kints.txt"));
        System.out.println(stopwatch.elapsedTime());

        stopwatch = new Stopwatch();
        int [] a = In.readInts("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/2Kints.txt");
        System.out.println(ThreeSumFast.count(a));
        System.out.println(stopwatch.elapsedTime());
    }
}
