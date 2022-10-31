package app;

import com.google.gson.internal.Streams;

public class AuthController {

    private static AuthController authController;

    private final AuthService authService;
    private AuthController()
    {

        authService=AuthService.getInstance();
    }

    public static AuthController getInstance()
    {
        if (authController == null){
            authController = new AuthController();
        }
        return authController;
    }

    public void createUser(String email, String name,String password){
       authService.createUser(email,name,password);
    }

}
