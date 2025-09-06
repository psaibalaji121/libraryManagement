package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;


    public List<Book> getAllBooks() {
        return libraryRepository.findAll();
    }

    public Book addBook(Book book) {
        return libraryRepository.save(book);
    }


    public Book getBookById(String id) {
        return libraryRepository.findById(id).orElse(null);
    }

    public boolean deleteBookById(String id) {
        if (libraryRepository.existsById(id)) {
            libraryRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Book update(String id, Book book) {
        Book existingBook = libraryRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setAuthor(book.getAuthor());
            existingBook.setBookName(book.getBookName());
            existingBook.setPublisher(book.getPublisher());
            return libraryRepository.save(existingBook);
        }
        return null;
    }
}
