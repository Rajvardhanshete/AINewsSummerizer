package com.newsaisummeriser.newsai.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String username;
    private String email;
    private Boolean isactive;
    private Timestamp createdat;
    private Timestamp updatedat;

    @ManyToMany(mappedBy = "users")
    private Set<Interest> interests;

    @ManyToMany
    @JoinTable(
            name = "bookmark",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "articleid")
    )
    private Set<Article> bookmarkedArticles;

    public User() {}

    // Getters and setters
    public Long getUserid() { return userid; }
    public void setUserid(Long userid) { this.userid = userid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getIsactive() { return isactive; }
    public void setIsactive(Boolean isactive) { this.isactive = isactive; }

    public Timestamp getCreatedat() { return createdat; }
    public void setCreatedat(Timestamp createdat) { this.createdat = createdat; }

    public Timestamp getUpdatedat() { return updatedat; }
    public void setUpdatedat(Timestamp updatedat) { this.updatedat = updatedat; }

    public Set<Interest> getInterests() { return interests; }
    public void setInterests(Set<Interest> interests) { this.interests = interests; }

    public Set<Article> getBookmarkedArticles() { return bookmarkedArticles; }
    public void setBookmarkedArticles(Set<Article> bookmarkedArticles) { this.bookmarkedArticles = bookmarkedArticles; }
}
