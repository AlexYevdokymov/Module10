package mainPackage;

import firstTask.ReaderForFirstTask;
import secondTask.JsonMaker;
import thirdTask.WordCounter;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //first task test
        File fileT1 = new File("fileT1.txt");
        ReaderForFirstTask.printValidNumbers(fileT1);
        System.out.println();

        //second task test
        File fileT2 = new File("fileT2.txt");
        JsonMaker.makeJson(fileT2);
        System.out.println();

        //third task test
        File fileT3 = new File("words.txt");
        WordCounter.count(fileT3);
    }
}