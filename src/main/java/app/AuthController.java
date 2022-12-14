package app;

import java.util.UUID;

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

        if (ValidationController.validateNewUser(name, password, email)) {
            authService.createUser(email, name, password);
        }
    }

    public UUID login(String email, String password){
        if (ValidationController.isValid(ValidationController.emailPat,email) &&
                ValidationController.isValid(ValidationController.passwordPat,password)){
            return authService.login(email,password);
        }
        return new UUID(0L, 0L);
    }

}
