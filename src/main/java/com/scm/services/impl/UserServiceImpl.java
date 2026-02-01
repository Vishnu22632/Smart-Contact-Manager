package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        // update user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVarified(user.isEmailVarified());
        user2.setPhoneNumberVarified(user.isPhoneNumberVarified());
        user2.setProvider(user.getProvider());
        user2.setProvideruserId(user.getProvideruserId());

        User save = userRepo.save(user2);
        return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user);
    }

    @Override
    public boolean isUserExist(Long id) {
        User user = userRepo.findById(id).orElse(null);

        return user != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
