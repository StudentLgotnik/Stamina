package com.project.spring.model;

import com.project.spring.dao.TypeDaoImpl;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "TYPE")
public class Type {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SCORE")
    private double score;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "USERID")
    private int userId;

    public Type(String language) {
        this.language = language;
        this.date = new Date();
    }



    public Type() {
        this.date = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDate() {
        this.date = new Date();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    public String getLanguage() {
        return language;
    }

    public Date getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", score=" + score +
                ", language='" + language + '\'' +
                ", data=" + date +
                ", userId=" + userId +
                '}';
    }
}
