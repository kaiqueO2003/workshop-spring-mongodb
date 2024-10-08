package com.kaiqueoliveira.workshopmongo.resource;

import com.kaiqueoliveira.workshopmongo.domain.User;
import com.kaiqueoliveira.workshopmongo.dto.UserDTO;
import com.kaiqueoliveira.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto= list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
