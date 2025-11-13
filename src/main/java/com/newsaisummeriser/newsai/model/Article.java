package com.newsaisummeriser.newsai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleid;

    @Column(nullable = false, length = 150)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(length = 500)
    private String summary;

    private String source;

    //Relationship: each article belongs to one topic
    @ManyToOne
    @JoinColumn(name = "topicid")
    private Topic topic;

    // Default constructor
    public Article() {}

    // Parameterized constructor
    public Article(String title, String content, String summary, String source) {
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.source = source;
    }

    // Getters and Setters
    public Long getArticleid() { return articleid; }
    public void setArticleid(Long articleid) { this.articleid = articleid; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }

    @Override
    public String toString() {
        return "Article{" +
                "articleid=" + articleid +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", source='" + source + '\'' +
                ", topic=" + (topic != null ? topic.getTopicname() : "none") +
                '}';
    }
}
