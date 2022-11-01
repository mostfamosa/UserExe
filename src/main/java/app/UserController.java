package app;

import java.util.UUID;

public class UserController {
    private static UserController userController;
    private final AuthService authService;
    private final UserService userService;

    private UserController() {
        authService = AuthService.getInstance();
        userService = UserService.getInstance();
    }

    public static UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    public void updateName(UUID token, String newName) {
        if (!ValidationController.isValid(ValidationController.namePat,newName.trim())) {
            System.out.println("Invalid name");
            return;
        }
        auth(token,newName,InputsTypes.NAME);

    }

    public void updateEmail(UUID token, String newEmail) {
        if (!ValidationController.isValid(ValidationController.emailPat,newEmail.trim())) {
            System.out.println("Invalid email");
            return;
        }
        auth(token,newEmail,InputsTypes.EMAIL);

    }

    public void updatePassword(UUID token, String newPassword) {
        if (!ValidationController.isValid(ValidationController.passwordPat,newPassword)) {
            System.out.println("Invalid password");
            return;
        }
        auth(token,newPassword,InputsTypes.PASSWORD);
    }

    private void auth(UUID token,String data,InputsTypes type){
        Integer userId = authService.isLoggedIn(token);
        if (userId != null) {
            userService.update(userId,data,type);
        }
    }

    public void deleteUser(UUID token){
        Integer id = authService.isLoggedIn(token);
        if (id != null){
            authService.removeToken(token);
            userService.deleteUser(id);
        }
    }
}
