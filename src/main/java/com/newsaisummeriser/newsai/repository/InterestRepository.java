package com.newsaisummeriser.newsai.repository;

import com.newsaisummeriser.newsai.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

}
