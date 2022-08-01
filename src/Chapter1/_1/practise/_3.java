package Chapter1._1.practise;
import java.io.IOException;

public class _3 {

    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        System.in.read();
        int b = System.in.read();
        System.in.read();
        int c = System.in.read();
        if (a == b && a == c)
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
