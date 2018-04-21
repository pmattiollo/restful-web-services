package br.com.pmattiollo.restfulwebservices.service;

import br.com.pmattiollo.restfulwebservices.bean.Post;
import br.com.pmattiollo.restfulwebservices.bean.User;
import br.com.pmattiollo.restfulwebservices.exception.UserNotFoundException;
import br.com.pmattiollo.restfulwebservices.repository.PostRepository;
import br.com.pmattiollo.restfulwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User retrieveUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Post createPost(Long userId, Post post) {
        User user = retrieveUser(userId);
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
