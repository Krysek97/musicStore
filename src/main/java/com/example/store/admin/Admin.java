package com.example.store.admin;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "ADMIN")
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long id;
    private String username;
    private String password;
    private final String role = "ADMIN";

    public Admin() {
    }

    public Admin(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
