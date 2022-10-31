package app;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repo {


    private static Repo repo;
    private final List<User> users;
    private final Gson gson;
    private final String filepath ;


    private Repo(){
        users = new ArrayList<>();
        filepath = ".src/main/resources/Users.json";
        gson = new Gson();
    }

    public static Repo getInstance()
    {
        if (repo == null){
            repo = new Repo();
        }
        return repo;
    }

    public void saveNewUser(User user){
       try(FileWriter writer =new FileWriter(filepath)) {
           users.add(user);
           gson.toJson(users, writer);
       } catch (FileNotFoundException e) {
           System.out.println("file not found, new file is created");
       } catch (IOException e) {
           e.printStackTrace();
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
