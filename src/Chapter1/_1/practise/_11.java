package Chapter1._1.practise;

public class _11 {
    boolean[][] arr;
    int colNum;
    int rowNum;

    public _11(int colNum, int rowNum) {
        this.colNum = colNum;
        this.rowNum = rowNum;
        this.arr = new boolean[rowNum][colNum];
    }

    public void fillArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                arr[i][i1] = i == i1 ? true : false;
            }
        }
    }

    public static void main(String[] args) {
        _11 obj = new _11(4, 4);
        obj.fillArr();

        boolean[][] arr = obj.arr;

        System.out.print("  ");
        for (int j = 0; j < arr[0].length; j++) {
            System.out.print(j+1 + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] ? "* " : "  ");
            }
            System.out.println();
        }
    }
}
