package app;

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

    public void updateName(String token ,String newName){
        if(!ValidationController.isValidName(newName)){
            return;
        }

    }

    public void updateEmail(String token,String newEmail){
        if(!ValidationController.isValidEmail(newEmail)){
            return;
        }
    }

    public void updatePassword(String token,String newPassword){
        if(!ValidationController.isValidPassword(newPassword)){
            return;
        }
    }
}
