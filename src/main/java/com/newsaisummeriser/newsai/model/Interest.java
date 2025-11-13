package com.newsaisummeriser.newsai.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "interests")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestid;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private Topic topic;

    @ManyToMany
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "interestid"),
            inverseJoinColumns = @JoinColumn(name = "userid")
    )
    private Set<User> users;

    public Interest() {}

    public Long getInterestid() {
        return interestid;
    }

    public void setInterestid(Long interestid) {
        this.interestid = interestid;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + interestid +
                ", topic=" + (topic != null ? topic.getTopicname() : "none") +
                '}';
    }

}
