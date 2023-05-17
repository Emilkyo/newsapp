package org.emil.newsapp.controller;

import org.emil.newsapp.domain.News;
import org.emil.newsapp.exception.SourceNotFoundException;
import org.emil.newsapp.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news/source")
public class NewsSource {
    final NewsService newsService;

    public NewsSource(NewsService newsService) {
        this.newsService = newsService;
    }

//    @GetMapping("/{source}")
//    public ResponseEntity getNewsBySourceId(@PathVariable String source) {
//        try {
//            List<News> newsList = newsService.getNewsBySourceId(source);
//            return ResponseEntity.ok(newsList);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Something went wrong");
//        }
//    }
}
