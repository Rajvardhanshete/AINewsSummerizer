package com.newsaisummeriser.newsai.controller;


import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article){
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@RequestBody Long id){
        articleService.deleteArticle(id);
    }


}
