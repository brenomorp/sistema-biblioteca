package com.breno.librarysystem.service;

import com.breno.librarysystem.model.Book;
import com.breno.librarysystem.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderService {
    private List<Reader> readers = new ArrayList<>();

    public void addReader(String id, String name, String cpf, int loanLimit) {
        Reader reader = new Reader(id, name, cpf, loanLimit);
        readers.add(reader);
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
    }

    public Reader searchById(String id) {
        for(Reader reader: readers) {
            if(reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    public Reader searchByName(String name) {
        for(Reader reader: readers) {
            if(reader.getName().equals(name)) {
                return reader;
            }
        }
        return null;
    }

    public Reader searchByCpf(String cpf) {
        for(Reader reader: readers) {
            if(reader.getCpf().equals(cpf)) {
                return reader;
            }
        }
        return null;
    }

    public List<Book> getReaderBooks(Reader reader) {
        return reader.getBooks();
    }

    public List<Reader> getReaders() {
        return readers;
    }
}