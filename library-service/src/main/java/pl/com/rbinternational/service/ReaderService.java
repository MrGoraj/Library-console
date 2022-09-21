package pl.com.rbinternational.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.rbinternational.model.Child;
import pl.com.rbinternational.model.Parent;
import pl.com.rbinternational.model.Reader;
import pl.com.rbinternational.repository.ChildRepository;
import pl.com.rbinternational.repository.ParentRepository;
import pl.com.rbinternational.repository.ReaderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    @Autowired
    private final ReaderRepository readerRepository;

    @Autowired
    private final ParentRepository parentRepository;

    @Autowired
    private final ChildRepository childRepository;

    public void addParent(String firstName, String lastName, String address, String phoneNumber) {
        parentRepository.save(new Parent(firstName, lastName, address, phoneNumber));
    }

    public void addChild(String firstName, String lastName, Long parentId) {
        if (parentRepository.findById(parentId).isPresent()) {
            childRepository.save(new Child(firstName, lastName, parentRepository.findById(parentId).get()));
        }
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }

    public Optional<Reader> findReaderById(Long id) {
        return readerRepository.findById(id);
    }

    /**
     * @return List of all readers found in the database
     */
    public List<Reader> findAllReaders() {
        List<Reader> readers = new ArrayList<>();
        readerRepository.findAll().iterator().forEachRemaining(readers::add);
        return readers;
    }

    public Iterable<Parent> findAllParents() {
        return parentRepository.findAll();
    }

    public Optional<Parent> findParentById(Long id) {
        return parentRepository.findById(id);
    }
}