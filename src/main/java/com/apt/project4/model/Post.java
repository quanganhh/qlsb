package com.apt.project4.model;

import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "T_POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 300)
    private String title;

    @Column(name = "content", length = 3000)
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
