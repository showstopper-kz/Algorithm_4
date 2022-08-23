package Chapter1._4;

import edu.princeton.cs.algs4.BinarySearch;

import java.beans.BeanInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/res_faster_O(NlogN).txt"));
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k =BinarySearch.rank(-a[i] - a[j], a);
                if (k > j) {
                    fileOutputStream.write(String.format("a[%d]: %d; a[%d]: %d; a[%d]: %d\n",i, a[i], j, a[j], k, a[k]).getBytes());
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
