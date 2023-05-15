package org.emil.newsapp.controller;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping
    public ResponseEntity createNews(@RequestBody News news,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(newsService.createNews(news, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

//    @PutMapping
//    public ResponseEntity updatedNews(@RequestParam Long id) {
//        try {
//            return null;
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Something went wrong");
//        }
//    }

    @PutMapping
    public ResponseEntity archived(@RequestParam Long id) {
        try {
            return ResponseEntity.ok("News is archived: " + newsService.archived(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
