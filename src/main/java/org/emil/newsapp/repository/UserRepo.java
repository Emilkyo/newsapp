package org.emil.newsapp.repository;

import org.emil.newsapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
