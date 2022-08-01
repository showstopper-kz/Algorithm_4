package Chapter1._1.practise;

public class _23 {
    public static void main(String[] args) {
        int key = 10;
        int[] searchArr = {1, 2, 4, 5, 10};
        binarySearch(10, searchArr, 0, searchArr.length-1, 0);
    }

    public static int binarySearch(int key, int []a, int lo, int hi, int level) {
        if (lo > hi) return - 1;
        System.out.println(addTab("", level) + lo + " " + hi);
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key) return binarySearch(key, a, lo, mid-1, level+1);
        else if (a[mid] < key) return binarySearch(key, a, mid+1, hi, level+1);
        return mid;
    }

    private static String addTab(String s, int level) {
        for (int i = 0; i < level; i++) {
            s = "    " + s;
        }
        return s;
    }
}
