package com.project.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "RECORD")
    private int record;

    @Column(name = "CURRENT")
    private boolean current;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getEmail() {
        return email;
    }

    public boolean getCurrent() {
        return current;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getRecord() {
        return record;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", record=" + record +
                ", current=" + current +
                '}';
    }
}
