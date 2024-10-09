package com.kaiqueoliveira.workshopmongo.resource;

import com.kaiqueoliveira.workshopmongo.domain.Post;
import com.kaiqueoliveira.workshopmongo.domain.User;
import com.kaiqueoliveira.workshopmongo.dto.UserDTO;
import com.kaiqueoliveira.workshopmongo.resource.util.URL;
import com.kaiqueoliveira.workshopmongo.service.PostService;
import com.kaiqueoliveira.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTittle(@RequestParam (value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
