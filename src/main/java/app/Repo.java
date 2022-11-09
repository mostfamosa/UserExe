package app;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Repo {
    private static Logger logger = LogManager.getLogger(Repo.class.getName());

    private final File[] files;
    private static Repo repo;
    private Map<Integer, User> users = new HashMap<>();
    private final Gson gson;
    private final String filepath;

    private Repo() {
        filepath = "src/main/resources/User/";
        gson = new Gson();
        files = new File("src/main/resources/Users/").listFiles();
        users = loadAllUsers();

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
        return users.get(id);
    }

    protected boolean deleteUser(Integer id) {
        users.remove(id);
        File file = new File(filepath + id + ".json");
        return file.delete();
    }

    protected void saveNewUser(User user) {
        Thread.dumpStack();
        logger.trace("You are trying to add new user to REPO");
        writeToFile("" + user.getId() + ".json", user);
    }

    private void writeToFile(String filename, User content) {
        try (FileWriter writer = new FileWriter(filepath + filename)) {
            logger.warn("You are trying to write data of a user to a file");
            gson.toJson(content, writer);
            users.put(content.getId(), content);
            logger.info("You added new user Successfully");
        } catch (IOException e) {
            logger.fatal("writeToFile: "+e);
            e.printStackTrace();
        }
    }

    Map<Integer, User> loadAllUsers() {
        try {
            for (File file : files) {
                User u = readFromFile(file.getName());
                assert u != null;
                users.put(u.getId(), u);
            }
            return users;
        } catch (NullPointerException e) {
            logger.fatal("loadAllUsers: "+e);
            e.printStackTrace();
        }
        return null;
    }

    private User readFromFile(String fileName) {
        try (FileReader reader = new FileReader(filepath + fileName)) {
            User u = gson.fromJson(reader, User.class);
            reader.close();
            return u;

        } catch (IOException e) {
            logger.fatal("readFromFile: "+e);
            e.printStackTrace();
        }
        return null;
    }

    protected void updateUser(User user) {
        try (FileWriter writer = new FileWriter(filepath + user.getId() + ".json")) {
            gson.toJson(user, writer);
            users.put(user.getId(), user);
        } catch (IOException e) {
            logger.fatal("updateUser: "+e);
            e.printStackTrace();
        }
    }

    protected int maximumId() {
        return users.keySet().stream().max(Integer::compareTo).orElse(0);
    }

}
