import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import  java.util.Collections;

public class UsersApp {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            BufferedReader br =  new BufferedReader(new FileReader("Users.txt.txt"));
            String line;
             while((line = br.readLine()) != null){
                 String[] parts = line.trim().split("\\s+");
                 if(parts.length != 2){
                     System.out.println(line + " -> invalid format");
                     continue;
                 }

                 try {
                     User user = new User(parts[0], parts[1]);
                     users.add(user);
                 }
                 catch (Exception e) {
                     System.out.println(line +"," + e.getMessage());
                 }
             }

             br.close();
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
        Collections.sort(users);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            for (User user : users) {
                bw.write(user.username + " " + user.password);
                bw.newLine();
            }

            bw.close();

        }
        catch (IOException e) {
            System.out.println("Error writing file");
        }


    }
}

