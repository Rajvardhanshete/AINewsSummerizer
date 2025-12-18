package com.newsaisummeriser.newsai.service.implementation;

import com.newsaisummeriser.newsai.model.Article;
import com.newsaisummeriser.newsai.model.Topic;
import com.newsaisummeriser.newsai.repository.ArticleRepository;
import com.newsaisummeriser.newsai.repository.TopicRepository;
import com.newsaisummeriser.newsai.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {


    private final TopicRepository topicRepository;
    private final ArticleRepository articleRepository;

    public TopicServiceImpl(TopicRepository topicRepository, ArticleRepository articleRepository) {
        this.topicRepository = topicRepository;
        this.articleRepository = articleRepository;
    }




    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopic(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    @Override
    public List<Article> getArticlesByTopic(Long topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        return List.copyOf(topic.getArticles());
    }

}
