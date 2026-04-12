import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import  java.util.Collections;


public class UsersApp {
    public static void main(String[] args) {
        // building array of users to hold the input
        ArrayList<User> users = new ArrayList<>();
        // try to read the users line by line from the input users file
        try {
            BufferedReader br =  new BufferedReader(new FileReader("Users.txt.txt"));
            String line;
             while((line = br.readLine()) != null){
                 String[] parts = line.trim().split("\\s+");
                 // check if we got both username and password
                 if(parts.length != 2){
                     System.out.println(line + " -> invalid format");
                     continue;
                 }
                 // try to create user object from the given input
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
        // handle file reading/opening error
        catch (IOException e) {
            System.out.println("Error reading file");
        }
        // sort the users array by the username order
        Collections.sort(users);
        // try write the users array into an output file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            // writing by the format
            for (User user : users) {
                bw.write(user.username + " " + user.password);
                bw.newLine();
            }

            bw.close();

        }
        // handling error of writing to file
        catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

