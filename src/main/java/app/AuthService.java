package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthService {

    private static AuthService authService;
    private final Repo repo;
    private final Map<UUID, Integer> tokens;
    private static AtomicInteger idCounter;

    private AuthService() {
        repo = Repo.getInstance();
        tokens = new HashMap<>();
        setIdCounter();
    }

    public static AuthService getInstance() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;
    }

    protected void createUser(String email, String name, String password) {
        if (emailExists(email)) {
            System.out.println("Error: This email already exists");
        } else {
            User user = new User(email, name, password, idCounter.getAndIncrement());
            repo.saveNewUser(user);
        }
    }

    protected Integer isLoggedIn(UUID token){
        if (tokens.get(token) == null){
            System.out.println("Error: Invalid token");
        }

        return tokens.get(token);
    }

    protected UUID login(String email, String password) {
        Optional<User> user = validLoginCredentials(email, password);
        UUID token;

        if(user.isPresent()){
            token = UUID.randomUUID();
            tokens.put(token , user.get().getId());
            System.out.println(user.get() + " Is logged in ");
        } else {
            token = new UUID(0L, 0L);
            System.out.println("Error: No such registered user with this credentials");
        }

        return token;
    }

    private boolean emailExists(String email) {
        return repo.getUsers().values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private Optional<User> validLoginCredentials(String email, String password){
        return repo.getUsers().values().stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst();
    }

    protected void removeToken(UUID token){
        tokens.remove(token);
    }

    private void setIdCounter(){
        idCounter = new AtomicInteger(repo.maximumId());
    }

}

