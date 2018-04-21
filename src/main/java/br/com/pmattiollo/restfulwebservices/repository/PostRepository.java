package br.com.pmattiollo.restfulwebservices.repository;

import br.com.pmattiollo.restfulwebservices.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
