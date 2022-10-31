package app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthService {

    private static AuthService authService;
    private final Repo repo;
    public HashMap<Integer,User> temp = new HashMap<>();
    private final Map<UUID, User> tokens;

    private AuthService() {
        repo =Repo.getInstance();
        tokens = new HashMap<>();
    }

    public static AuthService getInstance() {
        if (authService == null){
            authService = new AuthService();
        }
        return authService;
    }

    // TODO
    protected boolean createUser(String email, String name, String password){
        if (emailExists(email,temp)){
            return false;
        }
        User user = new User(email, name, password);
        temp.put(user.getId(), user);
        return true;
    }

    protected boolean isLoggedIn(UUID token){
        return tokens.containsKey(token);
    }

    protected void login(String email, String password){

    }

    //edit this function
    private static boolean emailExists(String email, HashMap<Integer, User> hm) {
        return hm.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }


}
