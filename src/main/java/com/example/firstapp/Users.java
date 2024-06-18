package com.example.firstapp;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_id_squence",
            sequenceName = "user_id_squence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_squence"
    )
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private String avatart;

    public Users(Integer id, String name, String avatart) {
        this.id = id;
        this.name = name;
        this.avatart = avatart;
    }

    public Users() {}

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
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(name, users.name) && Objects.equals(avatart, users.avatart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avatart);
    }
}
