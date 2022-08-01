package Chapter1._1.practise;

public class _30 {
    public static void main(String[] args) {
        boolean[][] res= new boolean[3][4];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = gcd(i, j) == 1 ? true : false;
            }
        }

    }

    public static int gcd(int p, int q) {
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
