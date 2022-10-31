package app;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ValidationController {

    private final String regex = "^(.+)@(.+)$";
    private final Pattern emailPat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private final Pattern namePat=Pattern.compile("^[A-Z](?=.{2,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");

    protected static boolean emailExists(String email, HashMap<Integer, User> hm) {
        return hm.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public static boolean validateNewUser(String name, String password,String email){

        return true;
    }
}
