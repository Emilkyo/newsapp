package org.emil.newsapp.model;

import lombok.Data;
import org.emil.newsapp.domain.News;
@Data
public class NewsModel {
    private Long id;
    private String title;
    private String topics;
    private String description;
    private String source;
    private Boolean archived;

    public static NewsModel toModel(News entity) {
        NewsModel model = new NewsModel();
        model.setArchived(entity.getArchived());
        model.setId(entity.getId());
        model.setDescription(entity.getDescription());
        model.setTitle(entity.getTitle());
        model.setSource(entity.getSource());
        return model;
    }
}
