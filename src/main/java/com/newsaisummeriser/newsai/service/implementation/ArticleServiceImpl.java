package com.newsaisummeriser.newsai.service.implementation;

import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.model.Topic;
import com.newsaisummeriser.newsai.repository.ArticleRepository;
import com.newsaisummeriser.newsai.repository.TopicRepository;
import com.newsaisummeriser.newsai.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final TopicRepository topicRepository;
    public ArticleServiceImpl(ArticleRepository articleRepository, TopicRepository topicRepository) {
        this.articleRepository = articleRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article saveArticleUnderTopic(Long topicId, Article article) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        article.setTopic(topic);
        return articleRepository.save(article);
    }
}
