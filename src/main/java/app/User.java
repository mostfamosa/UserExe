package app;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class User {

    private final int id;
    private  String email;
    private String name;
    private String password;

    User(String email, String name, String password, int id) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = id;
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

    protected int getId() {
        return id;
    }

    protected void setName(String name) { this.name = name; }

    protected void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

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
