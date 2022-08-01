package Chapter1._2.practise;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class _15 {
    public static void main(String[] args) throws IOException {
        int[] res = readInts("/Users/zhuyongqi/test.txt");
        System.out.println(Arrays.toString(res));
    }

    public static int[] readInts(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        String numbers = "";
        while (true) {
            int b = fileInputStream.read();
            if (b == -1) break;
            numbers += (char)b;
        }

        String[] splitArr = numbers.split("[ ,\n]");
        int[] res = new int[splitArr.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(splitArr[i]);
        }

        return res;
    }
}
