package com.newsaisummeriser.newsai.service;

import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.model.Topic;

import java.util.List;
import java.util.Set;


public interface TopicService {

    Topic createTopic(Topic topic);
    List<Topic> getAllTopics();
    Topic getTopic(Long id);
    Set<Article> getArticlesByTopic(Long topicId);
}
