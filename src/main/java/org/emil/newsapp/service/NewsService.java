package org.emil.newsapp.service;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.domain.User;
import org.emil.newsapp.exception.NewsNotFoundException;
import org.emil.newsapp.exception.UserNotFoundException;
import org.emil.newsapp.model.NewsModel;
import org.emil.newsapp.repository.NewsRepo;
import org.emil.newsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public NewsModel updateById(Long newsId, News updatedNews, Long userId) throws UserNotFoundException, NewsNotFoundException {
        News currentNews = newsRepo.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("News not found with id: " + newsId));
        if (currentNews.getUser().getId() != userId)
            throw new UserNotFoundException("User isn't owner");
        // Обновляем поля новости
        currentNews.setUpdatedTime(LocalDateTime.now());
        currentNews.setTitle(updatedNews.getTitle());
        currentNews.setTopic(updatedNews.getTopic());
        currentNews.setDescription(updatedNews.getDescription());
        currentNews.setSource(updatedNews.getSource());
        currentNews.setArchived(updatedNews.getArchived());
        return NewsModel.toModel(newsRepo.save(currentNews));
    }

    public NewsModel getOneNews(Long id) throws NewsNotFoundException {
        Optional<News> news = newsRepo.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("News not found with id: " + id);
        }
        return NewsModel.toModel(news.orElse(new News()));
    }

    public List<News> getAllNews(PageRequest pageRequest) {
        Page<News> page = newsRepo.findAll(pageRequest);
        return page.getContent();
    }

    public NewsModel archived(Long id) {
        News news = newsRepo.findById(id).get();
        news.setArchived(!news.getArchived());
        return NewsModel.toModel(newsRepo.save(news));
    }

    public Long delete(Long id) {
        newsRepo.deleteById(id);
        return id;
    }

//    public List<News> getNewsBySourceId(String sourceId) {
//        return newsRepo.findBySourceId(sourceId);
//    }
}
