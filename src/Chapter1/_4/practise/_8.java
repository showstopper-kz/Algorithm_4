package Chapter1._4.practise;


import Chapter1._1.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class _8 {

    public int findEqualParr(String filePath) {
        int res = 0;
        int[] a = In.readInts(filePath);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (a[i] == a[j])
                    res ++;
            }
        }
        return res;
    }

    public int findEqualPairLogN(String filePath) {
        int res = 0;
        int[] a = In.readInts(filePath);
        Arrays.sort(a);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (BinarySearch.rank(a[i], a)[0] > i)
                res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new _8().findEqualPairLogN("/Users/zhuyongqi/Projects/IdeaProjects/Algorithm_4/source/1Kints.txt");
        System.out.println(res);
    }
}
