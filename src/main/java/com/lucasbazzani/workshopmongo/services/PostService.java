package com.lucasbazzani.workshopmongo.services;

import com.lucasbazzani.workshopmongo.domain.Post;
import com.lucasbazzani.workshopmongo.domain.User;
import com.lucasbazzani.workshopmongo.repository.PostRepository;
import com.lucasbazzani.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}