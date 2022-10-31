import app.AuthController;
import app.AuthService;
import app.UserController;
import app.UserService;
import com.google.gson.Gson;

public class Client {

    public static void main(String[] args) {
        AuthController authController = AuthController.getInstance();
        AuthService authService = AuthService.getInstance();
        authController.createUser("mayabarkan@gmail.com", "maya", "mmmmM111");
        System.out.println(authService.temp);
    }
}
