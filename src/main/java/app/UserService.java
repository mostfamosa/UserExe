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

    protected void updateUser(User updatedUser) {

    }

    protected void deleteUser(Integer id){
        repo.deleteUser(id);
    }

}
