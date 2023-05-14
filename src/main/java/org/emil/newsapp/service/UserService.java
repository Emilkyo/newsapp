package org.emil.newsapp.service;

import org.emil.newsapp.domain.User;
import org.emil.newsapp.exception.UserAlreadyExistException;
import org.emil.newsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registration(User user) throws UserAlreadyExistException {
        if (userRepo.findUserByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("Something went wrong. Probably user already exist");
        return userRepo.save(user);
    }
}
