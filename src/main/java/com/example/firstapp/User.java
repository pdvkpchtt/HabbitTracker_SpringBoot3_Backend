package com.example.firstapp;

import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private String avatart;

    public User(Integer id, String name, String avatart) {
        this.id = id;
        this.name = name;
        this.avatart = avatart;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatart() {
        return avatart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatart(String avatart) {
        this.avatart = avatart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(avatart, user.avatart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avatart);
    }
}
