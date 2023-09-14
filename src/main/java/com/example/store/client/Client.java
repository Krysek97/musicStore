package com.example.store.client;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CLIENT")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;
    private String username;
    private String password;
    private Integer phoneNumber;
    private String address;
    private final String role = "CLIENT";

    public Client() {
    }

    public Client(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Client(Long id, String username, String password, Integer phoneNumber, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
