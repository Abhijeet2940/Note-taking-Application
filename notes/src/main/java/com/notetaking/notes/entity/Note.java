package com.notetaking.notes.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Title;
    private String Description;

    private LocalDateTime createAt;

    @PrePersist
    public void beforesave(){
        createAt= LocalDateTime.now();
    }

    public void  setDescription(String description) {
        this.Description = description;
    }
    public void setTitle(String title){
        this.Title= title;
    }

    public Integer getID() {
        return ID;
    }

    public String getDescription() {
        return Description;
    }
    public String getTitle(){
        return Title;
    }
}
