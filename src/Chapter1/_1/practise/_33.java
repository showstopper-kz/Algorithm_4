package Chapter1._1.practise;

public class _33 {
    public static void main(String[] args) {
    }
}

class Matrix{
    public static double dot(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        double[][] res = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                double sum = 0;
                for (int k = 0; k < a[i].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                a[i][j] = sum;
            }
        }
        return res;
    }

    public static double[][] transpose(double[][] a) {
        double[][] res = new double[a[0].length][a.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = a[j][i];
            }
        }
        return res;
    }

    public static double[] mult(double[][] a, double[] b) {
        double[] res = new double[b.length];
        for (int i = 0; i < a.length; i++) {
            double sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j] * b[j];
            }
            res[i] = sum;
        }
        return res;
    }

    public static double[] mult(double[] a, double[][] b) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < b.length; j++)
                sum  += a[i] * b[j][i];
            res[i] = sum;
        }
        return res;
    }
}
