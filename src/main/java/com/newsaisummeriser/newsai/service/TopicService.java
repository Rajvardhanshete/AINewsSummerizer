package com.newsaisummeriser.newsai.service;

import com.newsaisummeriser.newsai.model.Topic;
import com.newsaisummeriser.newsai.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id){
        return topicRepository.findById(id);
    }

    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id){
        topicRepository.deleteById(id);
    }

}
