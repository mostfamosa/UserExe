import app.AuthController;
import app.AuthService;

import java.util.UUID;

public class Client {

    public static void main(String[] args) {
        AuthController authController = AuthController.getInstance();
        AuthService authService = AuthService.getInstance();
        authController.createUser("mayabarkan@gmail.com", "Maya", "mmmmM111");
        UUID token1 = authController.login("mayabarkan@gmail.com", "mmmmM111");
        UUID token2 = authController.login("kmxx@gmail.com","cdcd1234M");
        System.out.println(token1);
        System.out.println(token2);

    }
}
