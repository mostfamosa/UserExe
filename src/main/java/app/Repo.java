package app;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repo {


    private static Repo repo;
    private final Map<Integer, User> users = new HashMap<>();
    private final Gson gson;
    private final String filepath;


    private Repo() {
        filepath = "src/main/resources/Users/";
        gson = new Gson();
    }

    protected static Repo getInstance() {
        if (repo == null) {
            repo = new Repo();
        }
        return repo;
    }
    protected Map<Integer, User> getUsers() {
        return users;
    }

    protected User getUserById(Integer id) {

        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            if (entry.getKey() == id)
                return entry.getValue();
        }
        System.out.println("User not found by id = " + id);
        return null;
    }

    protected void saveNewUser(User user) {
        writeToFile("" + user.getId() + ".json", user);

    }

    private void writeToFile(String filename, User content) {
        try (FileWriter writer = new FileWriter(filepath + filename)) {
            users.put(content.getId(), content);
            gson.toJson(content, writer);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //extra function
    private Map<Integer,User> loadAllUsers(){

        for (Map.Entry<Integer,User> entry : users.entrySet()){
            users.put(entry.getKey(),readFromFile(entry.getKey()+".json"));
        }
        return users;
    }

    private User readFromFile(String fileName) {
        try(FileReader reader = new FileReader(filepath+fileName)) {
            User u = gson.fromJson(reader,User.class);
            reader.close();
            return u;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected void updateUser(User user) {
        try (FileWriter writer = new FileWriter(filepath + user.getId()+".json")) {
            gson.toJson(user, writer);
            users.put(user.getId(), user);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
