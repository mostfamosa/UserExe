package app;

import com.google.gson.internal.Streams;

import java.security.SecureRandom;

public class AuthController {

    private static AuthController authController;

    private final AuthService authService;

    private AuthController() {
        authService = AuthService.getInstance();
    }


    public static AuthController getInstance() {
        if (authController == null) {
            authController = new AuthController();
        }
        return authController;
    }

    public void createUser(String email, String name, String password) {

        if (!ValidationController.validateNewUser(name, password, email)) {
            return;
        }
        authService.createUser(email, name, password);
    }

    public void login(String email, String password){
        if (ValidationController.isValidEmail(email) && ValidationController.isValidPassword(password)){
            authService.login(email,password);
        }
    }

}
