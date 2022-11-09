import app.AuthController;
import app.AuthService;
import app.UserController;
import app.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class Client {

    public static Logger logger = LogManager.getLogger(Client.class.getName());

    public static void main(String[] args) throws InterruptedException {
        AuthController authController = AuthController.getInstance();
        UserController userController = UserController.getInstance();


        authController.createUser("mostafa@gmail.com", "Moose", "Mostafa123456");
        authController.createUser("khalid@gmail.com", "Khalid", "Khalid123456");
        authController.createUser("maya@gmail.com", "Maya", "Maya123456");


        UUID token1 = authController.login("khalid@gmail.com", "Khalid123456");
        UUID token2 = authController.login("mostafa@gmail.com","Mostafa123456");

        userController.updateName(token1,"halidWani");
        userController.updateName(token1,"KhalidWani");
        userController.updatePassword(token1,"123456Khalid");
        userController.updatePassword(token1,"123456khalid");
        userController.updateEmail(token1,"Khalid@");
        userController.updateEmail(token1,"Khalid@hotmail.com");

        userController.deleteUser(token2);


    }
}
