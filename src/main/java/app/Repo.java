package app;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Repo {
    private ArrayList<User> users = new ArrayList<>(); //change to map <String, User>
    private Gson gson = new Gson();
    private String filepath = ".src/main/resources/Users.json";

    public void saveNewUser(User user) throws IOException {
       try {

           users.add(user);
           gson.toJson(users, new FileWriter(filepath));
       }catch (Exception e){
           throw new RuntimeException("Failed to write new user");
       }
    }

    private void loadUsers(){

    }

    private void writeToFile(String filename, User content){

    }

    private User readFromFile(String fileName){
        return null;
    }

    public void updateUser(User user){
        //make sure user exists- if id does then update user, else throw exception
    }





}
