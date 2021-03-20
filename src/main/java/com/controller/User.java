package com.controller;

public class User {
    private String username;
    private String password;

    public User() {
        System.out.println("无参构造");
    }

    public User(String username, String password) {
        System.out.println("有参构造");
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
