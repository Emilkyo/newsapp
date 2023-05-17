package org.emil.newsapp.repository;

import org.emil.newsapp.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {
}
