package org.emil.newsapp.model;

import lombok.Data;
import org.emil.newsapp.domain.News;
@Data
public class NewsModel {
    private Long id;
    private String title;
    private String description;

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    private Boolean isArchived;

    public static NewsModel toModel(News entity) {
        NewsModel model = new NewsModel();
        model.setId(entity.getId());
        model.setArchived(entity.isArchived());
        model.setDescription(entity.getDescription());
        model.setTitle(entity.getTitle());
        return model;
    }
}
