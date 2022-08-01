package Chapter1._3.practise;


import Chapter1._3.Queue;

import javax.naming.OperationNotSupportedException;
import java.io.File;

public class _43 {
    public static void printFile(File file, String prefix) {
        if (file.isDirectory()) {
            System.out.println(prefix + file.getName());
            for (File listFile : file.listFiles()) {
                if (file.isDirectory())
                    printFile(listFile, "   " + prefix);
                else
                    System.out.println(prefix + file.getName());
            }
        } else {
            System.out.println(prefix + file.getName());
        }
    }

    public static void printDir(String dirPath) throws OperationNotSupportedException{
        File dir = new File(dirPath);
        if (!dir.isDirectory())
            throw new OperationNotSupportedException("the given path is not a directory");
        else {
            printFile(dir,"");
        }
    }

    public static void main(String[] args) throws OperationNotSupportedException{
        printDir("/Users/zhuyongqi/Projects/c");
    }
}
