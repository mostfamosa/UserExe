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
        if (repo.deleteUser(id)) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("Error: user deletion failed");
        }
    }

}
