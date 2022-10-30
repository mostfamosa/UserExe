package app;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class User {

    private final int id;
    private static AtomicInteger idCounter = new AtomicInteger();
    private  String email; //TODO: MAKE SURE THAT THE EMAIL IS UNIQUE
    private String name;
    private String password;

    User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = createID();
    }

    private static int createID() {
        return idCounter.getAndIncrement();
    }

    protected String getName() {
        return name;
    }

    protected String getPassword() {
        return password;
    }

    protected String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
