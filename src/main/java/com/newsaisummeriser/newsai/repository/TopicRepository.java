package com.newsaisummeriser.newsai.repository;

import com.newsaisummeriser.newsai.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
