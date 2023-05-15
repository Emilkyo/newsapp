package org.emil.newsapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.emil.newsapp.domain.User;

import java.util.Optional;

@Data
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    public static UserModel toModel(Optional<User> entity) {
        UserModel model = new UserModel();
        model.setId(entity.get().getId());
        model.setUsername(entity.get().getUsername());
        return model;
    }
}
