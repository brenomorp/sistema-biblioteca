package com.breno.librarysystem.model;

import java.time.LocalDate;
import java.util.List;

public class Loan {
    private String id;
    private Reader reader;
    private List<Book> books;
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;

    public Loan() {}

    public Loan(String id, Reader reader, List<Book> books, LocalDate loanDate, LocalDate expectedReturnDate) {
        this.id = id;
        this.reader = reader;
        this.books = books;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", reader=" + reader +
                ", books=" + books +
                ", loanDate=" + loanDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", returnDate=" + returnDate +
                '}';
    }
}