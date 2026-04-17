package com.breno.librarysystem.service;

import com.breno.librarysystem.model.Book;
import com.breno.librarysystem.model.Loan;
import com.breno.librarysystem.model.Reader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private List<Loan> loans = new ArrayList<>();

    public void registerLoan(String id, Reader reader, List<Book> books) {
        Loan loan = new Loan(id, reader, books, LocalDate.now(), LocalDate.now().plusDays(30));
        loans.add(loan);

        for(Book book: books) {
            book.setAvailable(false);
            reader.getBooks().add(book);
        }
    }

    public void returnBook(Loan loan) {
        List<Book> booksToRemove = new ArrayList<>();
        loan.setReturnDate(LocalDate.now());

        for(Book book: loan.getBooks()) {
            book.setAvailable(true);
            booksToRemove.add(book);
        }

        loan.getReader().getBooks().removeAll(booksToRemove);

        if(loan.getReturnDate().isAfter(loan.getExpectedReturnDate())) {
            System.out.println("Livro devolvido em atraso");
        }
    }

    public boolean canBorrow(Reader reader, List<Book> books) {
        int currentSize = reader.getBooks().size();
        int requestedBooks = books.size();

        return (currentSize + requestedBooks) <= reader.getLoanLimit();
    }

    public Loan searchById(String id) {
        for(Loan loan: loans) {
            if(loan.getId().equals(id)) {
                return loan;
            }
        }
        return null;
    }

    public List<Loan> searchByReader(Reader reader) {
        List<Loan> loans = new ArrayList<>();
        for(Loan loan: this.loans) {
            if(loan.getReader().equals(reader)) {
                loans.add(loan);
            }
        }
        return loans;
    }

    public Loan searchByBook(Book book) {
        for(Loan loan: loans) {
            for(Book loanBook: loan.getBooks()) {
                if(book == loanBook) return loan;
            }
        }
        return null;
    }

    public List<Loan> searchByLoanDate(LocalDate loanDate) {
        List<Loan> loans = new ArrayList<>();

        for(Loan loan: this.loans) {
            if(loan.getLoanDate().equals(loanDate)) loans.add(loan);
        }

        return loans;
    }

    public List<Loan> searchByExpectedReturnDate(LocalDate expectedReturnDate) {
        List<Loan> loans = new ArrayList<>();

        for(Loan loan: this.loans) {
            if(loan.getExpectedReturnDate().equals(expectedReturnDate)) loans.add(loan);
        }

        return loans;
    }

    public List<Loan> searchByReturnDate(LocalDate returnDate) {
        List<Loan> loans = new ArrayList<>();

        for(Loan loan: this.loans) {
            if(loan.getReturnDate() == null) continue;
            if(loan.getReturnDate().equals(returnDate)) loans.add(loan);
        }

        return loans;
    }
}
