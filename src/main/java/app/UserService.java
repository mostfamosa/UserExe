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

    protected void update(int userId, String data, InputsTypes type) {
        User user = repo.getUserById(userId);
        if (user != null) {
            switch (type) {
                case EMAIL:
                    user.setEmail(data);
                    System.out.println("Email updated to : "+data);
                    break;
                case PASSWORD:
                    user.setPassword(data);
                    System.out.println("Password updated to : "+data);
                    break;
                case NAME:
                    user.setName(data);
                    System.out.println("Name updated to : "+data);
                    break;
                default:
                    System.out.println("type not good");
                    return;
            }
        }
        repo.updateUser(user);
    }

    protected void deleteUser(Integer id) {
        if (repo.deleteUser(id)) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("Error: user deletion failed");
        }
    }
}
