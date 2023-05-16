package org.emil.newsapp.service;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.domain.User;
import org.emil.newsapp.exception.NewsNotFoundException;
import org.emil.newsapp.model.NewsModel;
import org.emil.newsapp.model.UserModel;
import org.emil.newsapp.repository.NewsRepo;
import org.emil.newsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

//    public NewsModel archived(Long id) {
//        News news = newsRepo.findById(id).get();
//        news.setArchived(!news.getArchived());
//        return NewsModel.toModel(newsRepo.save(news));
//    }

    public Long delete(Long id) {
        newsRepo.deleteById(id);
        return id;
    }

    public NewsModel getOneNews(Long id) throws NewsNotFoundException {
        Optional<News> news = newsRepo.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("News not found");
        }
        return NewsModel.toModel(news.orElse(new News()));
    }
}
