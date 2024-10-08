package com.kaiqueoliveira.workshopmongo.repository;

import com.kaiqueoliveira.workshopmongo.domain.Post;
import com.kaiqueoliveira.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
