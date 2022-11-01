package app;

import java.util.regex.Pattern;

public class ValidationController {

    private static final Pattern emailPat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern namePat = Pattern.compile("^[A-Z](?=.{2,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");
    private static final Pattern passwordPat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");

    public static boolean validateNewUser(String name, String password, String email) {

        if (!ValidationController.isValidEmail(email)) {
            System.out.println("Invalid email");
            return false;
        }
        if (!ValidationController.isValidName(name)) {
            System.out.println("Invalid name");
            return false;
        }
        if (!ValidationController.isValidPassword(password)) {
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (!passwordPat.matcher(password).matches()) {
            System.out.println("Invalid password");
            return false;
        }
        return true;
    }

    public static boolean isValidName(String name) {
        if (!namePat.matcher(name).matches()) {
            System.out.println("Invalid name");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (!emailPat.matcher(email).matches()) {
            System.out.println("Invalid email");
            return false;
        }
        return true;
    }

}
