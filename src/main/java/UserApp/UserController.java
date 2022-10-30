package UserApp;

public class UserController {
    private static UserController userController;
    private final AuthService authService;
    private final UserService userService;
    private UserController()
    {
        authService=AuthService.getInstance();
        userService=UserService.getInstance();
    }

    public static UserController getInstance()
    {
        if (userController == null){
            userController = new UserController();
        }
        return userController;
    }
}
