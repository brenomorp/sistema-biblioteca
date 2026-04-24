package com.breno.librarysystem;

import com.breno.librarysystem.model.Book;
import com.breno.librarysystem.model.Loan;
import com.breno.librarysystem.model.Reader;
import com.breno.librarysystem.service.BookService;
import com.breno.librarysystem.service.LoanService;
import com.breno.librarysystem.service.ReaderService;
import com.breno.librarysystem.view.Menu;

import java.time.Year;
import java.util.List;

public class Main {
    static void main(String[] args) {
        BookService bookService = new BookService();
        ReaderService readerService = new ReaderService();
        LoanService loanService = new LoanService();

        seedData(bookService, readerService, loanService);
        testFeatures(bookService, readerService, loanService);
    }

    static void seedData(BookService bookService, ReaderService readerService, LoanService loanService) {
        bookService.addBook("Dom Casmurro", "Machado de Assis", Year.of(1899), "8594318601");
        bookService.addBook("O Cortiço", "Aluísio Azevedo", Year.of(1890), "8594318602");
        bookService.addBook("Memórias Póstumas", "Machado de Assis", Year.of(1881), "8594318603");

        readerService.addReader("001", "Breno Silva", "12345678901", 3);
        readerService.addReader("002", "Ana Lima", "98765432100", 2);
    }

    static void testFeatures(BookService bookService, ReaderService readerService, LoanService loanService) {
        System.out.println("=== LIVROS CADASTRADOS ===");
        bookService.getBooks().forEach(System.out::println);

        System.out.println("\n=== LEITORES CADASTRADOS ===");
        readerService.getReaders().forEach(System.out::println);

        System.out.println("\n=== REGISTRANDO EMPRÉSTIMO ===");
        Reader reader = readerService.searchById("001");
        Book book1 = bookService.searchBookByISBN("8594318601");
        Book book2 = bookService.searchBookByISBN("8594318602");

        if(loanService.canBorrow(reader, List.of(book1, book2))) {
            loanService.registerLoan("L001", reader, List.of(book1, book2));
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Limite de empréstimos atingido!");
        }

        System.out.println("\n=== LIVROS DO LEITOR ===");
        readerService.getReaderBooks(reader).forEach(System.out::println);

        System.out.println("\n=== DISPONIBILIDADE DOS LIVROS ===");
        System.out.println(book1.getTitle() + " - disponível: " + book1.isAvailable());
        System.out.println(book2.getTitle() + " - disponível: " + book2.isAvailable());

        System.out.println("\n=== DEVOLVENDO EMPRÉSTIMO ===");
        Loan loan = loanService.searchById("L001");
        loanService.returnBook(loan);
        System.out.println("Devolução registrada!");
        System.out.println(book1.getTitle() + " - disponível: " + book1.isAvailable());
        System.out.println(book2.getTitle() + " - disponível: " + book2.isAvailable());

        System.out.println("\n=== BUSCA POR ISBN ===");
        System.out.println(bookService.searchBookByISBN("8594318603"));

        System.out.println("\n=== BUSCA DE LEITOR POR CPF ===");
        System.out.println(readerService.searchByCpf("98765432100"));
    }
}
