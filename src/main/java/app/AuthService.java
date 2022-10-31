package app;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private static AuthService authService;
    private final Repo repo;
    public HashMap<Integer,User> temp = new HashMap<>();

    private AuthService() {
        repo =Repo.getInstance();
    }

    public static AuthService getInstance() {
        if (authService == null){
            authService = new AuthService();
        }
        return authService;
    }

    // TODO
    protected void createUser(String email, String name, String password){
        if (ValidationController.emailExists(email,temp)){
            throw new IllegalArgumentException("This email already exists");
        }
        User user = new User(email, name, password);
        temp.put(user.getId(), user);
        System.out.println("created user successfully");
        // write validation method to validate that the users repo does not contain a user with this email.
    }

}
