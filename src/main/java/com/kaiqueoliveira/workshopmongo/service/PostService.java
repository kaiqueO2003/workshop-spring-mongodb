package com.kaiqueoliveira.workshopmongo.service;

import com.kaiqueoliveira.workshopmongo.domain.Post;
import com.kaiqueoliveira.workshopmongo.domain.User;
import com.kaiqueoliveira.workshopmongo.dto.UserDTO;
import com.kaiqueoliveira.workshopmongo.repository.PostRepository;
import com.kaiqueoliveira.workshopmongo.repository.UserRepository;
import com.kaiqueoliveira.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;


    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
