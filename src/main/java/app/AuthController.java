package app;

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


}
