package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class.getName());

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
            logger.error("You are trying to update an invalid Name");
            System.out.println("Invalid name");
            return;
        }
        auth(token,newName,InputsTypes.NAME);
        logger.info("You updated the name Successfully");

    }

    public void updateEmail(UUID token, String newEmail) {
        if (!ValidationController.isValid(ValidationController.emailPat,newEmail.trim())) {
            logger.error("You are trying to update an invalid Email");
            System.out.println("Invalid email");
            return;
        }
        auth(token,newEmail,InputsTypes.EMAIL);

    }

    public void updatePassword(UUID token, String newPassword) {
        if (!ValidationController.isValid(ValidationController.passwordPat,newPassword)) {
            logger.error("You are trying to update an invalid password");
            System.out.println("Invalid password");
            return;
        }
        auth(token,newPassword,InputsTypes.PASSWORD);
        logger.info("You updated the password Successfully");
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
