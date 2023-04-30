package mainPackage;

import firstTask.ReaderForFirstTask;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");
        ReaderForFirstTask.printValidNumbers(file);
    }
}