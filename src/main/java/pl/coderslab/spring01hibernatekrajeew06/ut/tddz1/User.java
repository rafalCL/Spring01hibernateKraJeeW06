package pl.coderslab.spring01hibernatekrajeew06.ut.tddz1;

public class User {
    private int id;
    private String username;

    public User() {
    }

    // copy constructor
    public User(User other) {
        this.id = other.id;
        this.username = other.username;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
