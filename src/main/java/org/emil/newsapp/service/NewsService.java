package org.emil.newsapp.service;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.domain.User;
import org.emil.newsapp.model.NewsModel;
import org.emil.newsapp.repository.NewsRepo;
import org.emil.newsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepo newsRepo;
    @Autowired
    private UserRepo userRepo;

    public NewsModel createNews(News news, Long userId) {
        User user = userRepo.findById(userId).get();
        news.setUser(user);
        return NewsModel.toModel(newsRepo.save(news));
    }

    public News updateNews(Long id) {
        return null;
    }

    public NewsModel archived(Long id) {
        News news = newsRepo.findById(id).get();
        news.setArchived(!news.isArchived());
        return NewsModel.toModel(newsRepo.save(news));
    }
}
