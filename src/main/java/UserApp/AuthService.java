package UserApp;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private static AuthService authService;
    private final Map<String, User> authUsers;
    private final Repo repo;

    private AuthService() {
        repo=Repo.getInstance();
        authUsers = new HashMap<>();
    }

    public static AuthService getInstance() {
        if (authService == null) {
            authService = new AuthService();
        }
        return authService;
    }
}
