package app;

public class AuthService {

    // TODO
    protected User createNewUser(String email, String name, String password){
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
