package com.breno.librarysystem.service;

import com.breno.librarysystem.model.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author, Year publicationYear, String isbn) {
        Book newBook = new Book(title, author, publicationYear, isbn);
        books.add(newBook);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBookByISBN(String isbn) {
        for(Book book: books) {
            if(book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public Book searchBookByTitle(String title) {
        for(Book book: books) {
            if(book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }
}