package pl.com.rbinternational.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.rbinternational.model.Author;
import pl.com.rbinternational.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(String firstName, String lastName) {
        authorRepository.save(new Author(firstName, lastName));
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public String findAuthorById(Long authorId) {
        return authorRepository.findById(authorId).get().toString();
    }
}
