package Chapter1._1.practise;

import Chapter1._3.Stack;
import com.sun.tools.classfile.ConstantPool;

public class _45 {
    public static boolean checkIfUnderFlow(String order) {
        int cnt = 0;
        for (char c : order.toCharArray()) {
            if (c == '-') cnt --;
            else cnt ++;
            if (cnt < 0) return false;
        }
        return true;
    }

    private static class retType {
        boolean flag;
        String res;

        public retType(boolean flag, String res) {
            this.flag = flag;
            this.res = res;
        }
    }

    public static retType checkIfCanGenOrder(String srcOrder, String desOrder) {
        Stack<Character> stack = new Stack<>();
        char[] desArr = desOrder.toCharArray();
        int pointer = 0;
        String res = "";
        boolean checkFlag = true;

        for (char c : srcOrder.toCharArray()) {
            res += c;
            if (checkFlag && c == desArr[pointer]) {
                res += '-';
                pointer++;
                if (pointer == desArr.length) checkFlag = false;
            } else {
                stack.push(c);
            }
        }

        boolean flag = (desArr.length  == pointer);

        return flag ? new retType(true, res) : new retType(false, "");
    }

    public static void main(String[] args) {
        // boolean res = checkIfUnderFlow("23--3--4324");
        retType res = checkIfCanGenOrder("12345", "13");
        if (res.flag) {
            System.out.println(res.res);
        } else {
            System.out.println(res.flag);
        }
    }
}
