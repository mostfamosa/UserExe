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

    protected boolean isLoggedIn(UUID token){
        return tokens.containsKey(token);
    }

    protected void login(String email, String password) {
        if(validLoginCredentials(email, password)){
            
        }

    }

    //edit this function
    private boolean emailExists(String email) {
        return repo.getUsers().values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private boolean validLoginCredentials(String email, String password){
        return repo.getUsers().values().stream().anyMatch(User :: emailPasswordMatch);
    }





}
