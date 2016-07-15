package ru.stasdev.controller.forms;

import ru.stasdev.domain.User;

public class UserForm {
    private String userId;
    private String firstName;
    private String lastName;

    public UserForm() {
    }

    public UserForm(User user) {
        this.userId = Long.toString(user.getId());
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
