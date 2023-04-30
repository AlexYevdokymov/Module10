package firstTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderForFirstTask {
    public static void printValidNumbers(File file) {
        StringBuilder sb = new StringBuilder();
        //read file content into StringBuilder
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

        //split lines to String array
        String[] numbers = sb.toString().split("\n");

        //patterns for 2 types of phone numbers
        Pattern pattern1 = Pattern.compile("^((\\()([0-9]{3})(\\))( {1})([0-9]{3})(-{1})([0-9]{4}))$");
        Pattern pattern2 = Pattern.compile("^(([0-9]{3})(-{1})([0-9]{3})(-{1})([0-9]{4}))$");

        //check phone numbers and print valid ones
        for (String number : numbers) {
            Matcher matcher1 = pattern1.matcher(number);
            Matcher matcher2 = pattern2.matcher(number);
            if(matcher1.matches() || matcher2.matches()) {
                System.out.println(number);
            }
        }
    }
}
