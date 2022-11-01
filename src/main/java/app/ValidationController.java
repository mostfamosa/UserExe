package app;

import java.util.regex.Pattern;

public class ValidationController {

    protected static final Pattern emailPat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    protected static final Pattern namePat = Pattern.compile("^[A-Z](?=.{2,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");
    protected static final Pattern passwordPat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");

    public static boolean validateNewUser(String name, String password, String email) {

        if (!ValidationController.isValid(emailPat,email.trim())) {
            System.out.println("Invalid password");
            return false;
        }
        if (!ValidationController.isValid(namePat,name.trim())) {
            System.out.println("Invalid name");
            return false;
        }
        if (!ValidationController.isValid(passwordPat,password)) {
            System.out.println("Invalid email");
            return false;
        }
        return true;
    }

    public static boolean isValid(Pattern p,String input) {
        if (!p.matcher(input).matches()) {
            System.out.println("Invalid password");
            return false;
        }
        return true;
    }

}
