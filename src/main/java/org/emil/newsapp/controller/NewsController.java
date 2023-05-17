package org.emil.newsapp.controller;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.exception.NewsNotFoundException;
import org.emil.newsapp.exception.UserNotFoundException;
import org.emil.newsapp.model.NewsModel;
import org.emil.newsapp.service.NewsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity createNews(@RequestBody News news,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(newsService.createNews(news, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @PutMapping("/{newsId}")
    public ResponseEntity updateById(@PathVariable Long newsId,
                                     @RequestParam Long userId,
                                     @RequestBody News updatedNews) {
        try {
            NewsModel updated = newsService.updateById(newsId, updatedNews, userId);
            return ResponseEntity.ok(updated);
        } catch (NewsNotFoundException | UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping("/all")
    public List<News> getAllNews(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size
    ) {
        return newsService.getAllNews(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    @ExceptionHandler(NewsNotFoundException.class)
    public ResponseEntity getOneNews(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(newsService.getOneNews(id));
        } catch (NewsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity deleteNews(@RequestParam Long id) {
        try {
            return ResponseEntity.ok("News with id: " + newsService.delete(id) + " deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

}
