package com.newsaisummeriser.newsai.service;

import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    private List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    private Optional<Article> getArticle(Long id){
        return articleRepository.findById(id);
    }

    private Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    private void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }
}
