package app;

public class AuthService {


    private static AuthService authService;
    private final Repo repo;
    private AuthService()
    {
        repo =Repo.getInstance();
    }

    public static AuthService getInstance()
    {
        if (authService == null){
            authService = new AuthService();
        }
        return authService;
    }

    // TODO
    protected User createUser(String email, String name, String password){
        if (emailExists(email)){
            throw new IllegalArgumentException("This email already exists");
        }
        return null;
        // write validation method to validate that the users repo does not contain a user with this email.

    }

    //TODO
    private static boolean emailExists(String email) {
        return false;
    }


}
