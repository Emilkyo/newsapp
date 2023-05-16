package org.emil.newsapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.emil.newsapp.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    private String role;            //думаю лучше переписать в ENUM
    private List<NewsModel> news;   //массив моделей задач, а не существ

    public static UserModel toModel(User entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setNews(entity.getNewsList().stream()
                .map(NewsModel::toModel).collect(Collectors.toList()));
        // в entity массив entity задач
        return model;
    }

}
