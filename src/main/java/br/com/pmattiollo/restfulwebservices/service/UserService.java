package br.com.pmattiollo.restfulwebservices.service;

import br.com.pmattiollo.restfulwebservices.bean.Post;
import br.com.pmattiollo.restfulwebservices.bean.User;

import java.util.List;

public interface UserService {

    List<User> retrieveAllUsers();

    User retrieveUser(Long id);

    User createUser(User user);

    Post createPost(Long userId, Post post);

    void deleteUser(Long id);

}
