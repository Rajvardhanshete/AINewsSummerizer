package com.newsaisummeriser.newsai.controller;

import com.newsaisummeriser.newsai.model.Topic;
import com.newsaisummeriser.newsai.service.TopicService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService){
        this.topicService = topicService;
    }

    @GetMapping
    public String listTopics(Model model){
        List<Topic> topics = topicService.getAllTopics();
        model.addAttribute("topics",topics);
        return "topics/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("topics", new Topic());
        return "topics/add";
    }
}
