package secondTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonMaker {
    public static void makeJson(File file) {
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

        //making users from String
        String[] lines = sb.toString().split("\n");
        ArrayList<User> users = new ArrayList<>();
        for(int i = 1; i < lines.length; i++) {
            String[] content = lines[i].split(" ");
            User user = new User(content[0], Integer.parseInt(content[1]));
            users.add(user);
        }

        //write json into file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        File userFile = new File("user.json");
        try (FileWriter writer = new FileWriter(userFile))
        {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("File \"" + userFile.getName() + "\" is created at " + userFile.getAbsolutePath());
    }
}
