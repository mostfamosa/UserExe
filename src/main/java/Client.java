import app.AuthController;
import app.AuthService;
import app.UserController;
import app.UserService;
import com.google.gson.Gson;

public class Client {

    public static void main(String[] args) {
        AuthController authController = AuthController.getInstance();
        AuthService authService = AuthService.getInstance();
        authController.createUser("mayabarkan@gmail.com", "Maya", "mmmmM111");
        authController.login("mayabarkan@gmail.com", "mmmmM111");
        authController.login("kmxx@gmail.com","cdcd1234M");


    }
}
