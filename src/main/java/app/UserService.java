package app;

public class UserService {


    private static UserService userService;
    private final Repo repo;

    private UserService() {
        repo = Repo.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    protected void updateName(int userId ,String newName){
         User oldUser = getUserById(userId);
         if(oldUser == null){
            return;
         }

    }

    protected void updateEmail(int userId ,String newEmail){

    }

    protected void updatePassword(int userId , String newPassword){

    }
}
