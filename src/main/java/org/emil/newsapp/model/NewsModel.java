package org.emil.newsapp.model;

import lombok.Data;
import org.emil.newsapp.domain.News;

@Data
public class NewsModel {
    private Long id;
    private String title;
    private String topic;
    private String description;
    private String source;
    private Boolean archived;
    private Long owner;

    public static NewsModel toModel(News entity) {
        NewsModel model = new NewsModel();
        model.setArchived(entity.getArchived());
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setTopic(entity.getTopic());
        model.setDescription(entity.getDescription());
        model.setSource(entity.getSource());
        model.setOwner(entity.getUser().getId());
        return model;
    }

    public static NewsModel toEntity(NewsModel newModel) {
        return newModel;
    }
}
