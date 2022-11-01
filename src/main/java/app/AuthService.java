package app;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthService {

    private static AuthService authService;
    private final Repo repo;
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


    protected void createUser(String email, String name, String password){
        if (emailExists(email)) {
            System.out.println("This email already exists");
        } else {
            User user = new User(email, name, password);
            repo.saveNewUser(user);
        }
    }

    protected User isLoggedIn(UUID token){
        return tokens.get(token);
    }

    protected void login(String email, String password){

    }

    //edit this function
    private boolean emailExists(String email) {
        return repo.getUsers().values().stream().anyMatch(user -> user.getEmail().equals(email));
    }


}
