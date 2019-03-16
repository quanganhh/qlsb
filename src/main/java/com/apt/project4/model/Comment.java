package com.apt.project4.model;

import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "T_COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content", length = 300)
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
