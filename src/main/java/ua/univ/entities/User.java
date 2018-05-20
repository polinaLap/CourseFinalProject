package ua.univ.entities;

import java.util.List;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String email;
    private String password;

    public void setSuccess(Success success) {
        this.success = success;
    }

    private Success success;
    private UserType type=UserType.STUDENT;
    public User(String name, String email, String password) {
        this.name =name;
        this.email = email;
        this.password = password;
        this.success = new Success();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type=type;

    }

    public Success getSuccess() {
        return success;
    }
}
