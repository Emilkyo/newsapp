package org.emil.newsapp.service;

import org.emil.newsapp.domain.User;
import org.emil.newsapp.exception.UserAlreadyExistException;
import org.emil.newsapp.exception.UserNotFoundException;
import org.emil.newsapp.model.UserModel;
import org.emil.newsapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User registration(User user) throws UserAlreadyExistException {
        if (userRepo.findUserByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("Something went wrong. Probably user already exist");
        return userRepo.save(user);
    }

    public UserModel getOneUser(Long id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return UserModel.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
