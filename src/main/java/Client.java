import app.AuthController;
import app.AuthService;
import app.UserController;
import app.UserService;

import java.util.UUID;

public class Client {

    public static void main(String[] args) {
        AuthController authController = AuthController.getInstance();
        UserController userController = UserController.getInstance();

        authController.createUser("maya2@gmail.com", "Maya", "mmmmM111");

        //UUID token1 = authController.login("mayabarkan@gmail.com", "mmmmM111");
        //UUID token2 = authController.login("kmxx@gmail.com","cdcd1234M");
        //userController.deleteUser(token1);
        //userController.deleteUser(token2);


    }
}
