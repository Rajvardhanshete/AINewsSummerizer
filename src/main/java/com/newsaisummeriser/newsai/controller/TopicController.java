package com.newsaisummeriser.newsai.controller;

import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.model.Topic;
import com.newsaisummeriser.newsai.service.ArticleService;
import com.newsaisummeriser.newsai.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/topic")
@CrossOrigin(origins = "*") // allow React access
public class TopicController {

    private final TopicService topicService;

    private final ArticleService articleService;
    public TopicController(TopicService topicService,
                           ArticleService articleService) {
        this.topicService = topicService;
        this.articleService = articleService;
    }

    @GetMapping("/{topicId}/articles")
    public Set<Article> getArticlesByTopic(@PathVariable Long topicId){
        return topicService.getArticlesByTopic(topicId);
    }


    @PostMapping("/{topicId}/articles")
    public Article addArticleToTopic(
            @PathVariable Long topicId,
            @RequestBody Article article){
        return articleService.saveArticleUnderTopic(topicId, article);
    }

    @PostMapping
    public Topic create(@RequestBody Topic topic){
        return topicService.createTopic(topic);
    }


    @GetMapping
    public List<Topic> getAll(){
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getOne(@PathVariable Long id){
        return topicService.getTopic(id);
    }


}
