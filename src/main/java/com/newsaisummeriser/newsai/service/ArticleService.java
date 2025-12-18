package com.newsaisummeriser.newsai.service;

import com.newsaisummeriser.newsai.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getAllArticles();
    Optional<Article> getArticleById(Long id);
    Article saveArticle(Article article);
    void deleteArticle(Long id);
    Article saveArticleUnderTopic(Long topicId, Article article);

}
