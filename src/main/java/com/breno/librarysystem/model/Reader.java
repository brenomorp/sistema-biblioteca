package com.breno.librarysystem.model;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String id;
    private String name;
    private String cpf;
    private List<Book> books;
    private int loanLimit;

    public Reader() {}

    public Reader(String id, String name, String cpf, int loanLimit) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.books = new ArrayList<>();
        this.loanLimit = loanLimit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(int loanLimit) {
        this.loanLimit = loanLimit;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", books=" + books +
                ", loanLimit=" + loanLimit +
                '}';
    }
}
