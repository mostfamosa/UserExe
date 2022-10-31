package app;


import java.util.HashMap;

public class ValidationController {

    private final String regex = "^(.+)@(.+)$";

    protected static boolean emailExists(String email, HashMap<Integer, User> hm) {
        return hm.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }



    
}
