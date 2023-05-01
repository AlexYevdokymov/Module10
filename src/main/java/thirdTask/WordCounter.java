package thirdTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class WordCounter {
    public static void count(File file) {
        StringBuilder sb = new StringBuilder();

        //reading file content into StringBuilder
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                char symbol = (char) buffer[i];
                sb.append(symbol);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //counting words
        String[] words = sb.toString().replace("\n"," ").strip().split(" ");
        Map<String, Integer> uniqueWords = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String tempWord = words[i];
            if(!uniqueWords.containsKey(tempWord)) {
                uniqueWords.put(tempWord, 1);
            } else {
                uniqueWords.put(tempWord, uniqueWords.get(tempWord) + 1);
            }
        }

        //sorting by values
        List<Map.Entry<String, Integer>> list = new ArrayList<>(uniqueWords.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue() - e1.getValue();
        }
        });

        //printing
        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
