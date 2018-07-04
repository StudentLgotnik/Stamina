package com.project.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGES")
public class Language {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "TEXT")
    private String text;

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", language=" + language +
                ", text=" + text +
                '}';
    }
}
