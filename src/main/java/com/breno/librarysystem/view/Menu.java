package com.breno.librarysystem.view;

import com.breno.librarysystem.model.Book;
import com.breno.librarysystem.model.Loan;
import com.breno.librarysystem.model.Reader;
import com.breno.librarysystem.service.BookService;
import com.breno.librarysystem.service.LoanService;
import com.breno.librarysystem.service.ReaderService;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        ReaderService readerService = new ReaderService();
        BookService bookService = new BookService();
        LoanService loanService = new LoanService();
        int opt;

        while(true) {
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1 - Gerenciar leitores");
            System.out.println("2 - Gerenciar livros");
            System.out.println("3 - Gerenciar Empréstimos");
            System.out.println("0 - Sair");

            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1: {
                    System.out.println("Gerenciar Leitores:");
                    System.out.println("1 - Cadastrar leitor");
                    System.out.println("2 - Remover leitor");
                    System.out.println("3 - Pesquisar leitor");
                    System.out.println("0 - Voltar");

                    opt = sc.nextInt();
                    sc.nextLine();

                    switch (opt) {
                        case 1: {
                            String id;
                            String name;
                            String cpf;
                            int loanLimit;

                            System.out.print("Digite o id do leitor: ");
                            id = sc.nextLine();
                            System.out.print("Digite o nome do leitor: ");
                            name = sc.nextLine();
                            System.out.print("Digite o CPF (11 digitos sem ponto e sem traço) do leitor: ");
                            cpf = sc.nextLine();
                            System.out.print("Digite a quantidade máxima de livros que o leitor alugar: ");
                            loanLimit = sc.nextInt();
                            sc.nextLine();

                            readerService.addReader(id, name, cpf, loanLimit);
                            break;
                        }
                        case 2: {
                            String id;

                            System.out.print("Digite o ID do leitor a ser removido: ");
                            id = sc.nextLine();
                            readerService.removeReader(readerService.searchById(id));
                            break;
                        }
                        case 3: {
                            System.out.println("Pesquisar Leitor:");
                            System.out.println("1 - Pesquisar por ID");
                            System.out.println("2 - Pesquisar por nome");
                            System.out.println("3 - Pesquisar por CPF");
                            System.out.println("0 - Voltar");

                            opt = sc.nextInt();
                            sc.nextLine();
                            switch (opt) {
                                case 1: {
                                    String id;
                                    Reader reader;

                                    System.out.print("Digite o ID do leitor: ");
                                    id = sc.nextLine();
                                    reader = readerService.searchById(id);
                                    if (reader != null) {
                                        System.out.println(reader);
                                    } else {
                                        System.out.println("Usuário não encontrado");
                                    }
                                    break;
                                }
                                case 2: {
                                    String name;
                                    Reader reader;

                                    System.out.print("Digite o nome do leitor: ");
                                    name = sc.nextLine();
                                    reader = readerService.searchByName(name);
                                    if (reader != null) {
                                        System.out.println(reader);
                                    } else {
                                        System.out.println("Usuário não encontrado");
                                    }
                                    break;
                                }
                                case 3: {
                                    String cpf;
                                    Reader reader;

                                    System.out.print("Digite o CPF do leitor: ");
                                    cpf = sc.nextLine();
                                    reader = readerService.searchByCpf(cpf);
                                    if (reader != null) {
                                        System.out.println(reader);
                                    } else {
                                        System.out.println("Usuário não encontrado");
                                    }
                                    break;
                                }
                                default:
                                    break;
                            }
                        }
                        default:
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Gerenciar Livros:");
                    System.out.println("1 - Cadastrar livro");
                    System.out.println("2 - Remover livro");
                    System.out.println("3 - Pesquisar livro");
                    System.out.println("0 - Voltar");


                    opt = sc.nextInt();
                    sc.nextLine();
                    switch (opt) {
                        case 1: {
                            String title;
                            String author;
                            Year publicationYear;
                            String isbn;

                            System.out.print("Digite o título do livro: ");
                            title = sc.nextLine();
                            System.out.print("Digite o autor do livro: ");
                            author = sc.nextLine();
                            System.out.print("Digite o ano de publicação do livro: ");
                            int year = sc.nextInt();
                            sc.nextLine();
                            publicationYear = Year.of(year);
                            System.out.print("Digite o ISBN (10 ou 13 dígitos) do livro: ");
                            isbn = sc.nextLine();

                            bookService.addBook(title, author, publicationYear, isbn);
                            break;
                        }
                        case 2: {
                            String isbn;

                            System.out.print("Digite o ISBN do livro a ser removido: ");
                            isbn = sc.nextLine();

                            bookService.removeBook(bookService.searchBookByISBN(isbn));
                            break;
                        }
                        case 3: {
                            System.out.println("Pesquisar Livro:");
                            System.out.println("1 - Pesquisar por título");
                            System.out.println("2 - Pesquisar por ISBN");
                            System.out.println("0 - Voltar");

                            opt = sc.nextInt();
                            sc.nextLine();
                            switch (opt) {
                                case 1: {
                                    String title;

                                    System.out.print("Digite o título do livro: ");
                                    title = sc.nextLine();

                                    for(Book book: bookService.getBooks()) {
                                        if(book.getTitle().equalsIgnoreCase(title)) {
                                            System.out.println(book);
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    String isbn;

                                    System.out.print("Digite o título do livro: ");
                                    isbn = sc.nextLine();

                                    for(Book book: bookService.getBooks()) {
                                        if(book.getIsbn().equalsIgnoreCase(isbn)) {
                                            System.out.println(book);
                                        }
                                    }
                                    break;
                                }
                                default:
                                    break;
                            }
                            break;
                        }
                        default:
                            break;
                    }

                    break;
                }
                case 3: {
                    System.out.println("Gerenciar Empréstimos:");
                    System.out.println("1 - Cadastrar empréstimo");
                    System.out.println("2 - Devolver empréstimo");
                    System.out.println("3 - Pesquisar empréstimo");
                    System.out.println("0 - Voltar");

                    opt = sc.nextInt();
                    sc.nextLine();
                    switch (opt) {
                        case 1: {
                            String id;
                            Reader reader;
                            List<Book> books = new ArrayList<>();
                            int quantity;
                            String readerName;

                            System.out.print("Digite o ID do empréstimo: ");
                            id = sc.nextLine();
                            System.out.print("Digite a quantidade de livros: ");
                            quantity = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Digite o nome do leitor: ");
                            readerName = sc.nextLine();
                            reader = readerService.searchByName(readerName);
                            for(int i = 0; i < quantity; i++) {
                                System.out.print("Digite o ISBN do livro " + (i+1) + ":");
                                String isbn = sc.nextLine();
                                books.add(bookService.searchBookByISBN(isbn));
                            }

                            if(loanService.canBorrow(reader, books)) {
                                try {
                                    loanService.registerLoan(id, reader, books);
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Limite máximo de livros ultrapassado!");
                            }
                            break;
                        }
                        case 2: {
                            String id;
                            Loan loan;

                            System.out.print("Digite o ID do empréstimo a ser devolvido: ");
                            id = sc.nextLine();
                            loan = loanService.searchById(id);

                            if(loan != null) {
                                loanService.returnBook(loan);
                            } else {
                                System.out.println("ID do empréstimo inválido!");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Pesquisar Empréstimo:");
                            System.out.println("1 - Pesquisar por ID");
                            System.out.println("2 - Pesquisar por leitor");
                            System.out.println("3 - Pesquisar por livro");
                            System.out.println("4 - Pesquisar por data de empréstimo");
                            System.out.println("5 - Pesquisar por data prevista de devolução");
                            System.out.println("6 - Pesquisar por data de devolução");
                            System.out.println("0 - Voltar");

                            opt = sc.nextInt();
                            sc.nextLine();
                            switch(opt) {
                                case 1: {
                                    System.out.print("Digite o ID do empréstimo: ");
                                    String id = sc.nextLine();
                                    Loan loan = loanService.searchById(id);
                                    if(loan != null) {
                                        System.out.println(loan);
                                    } else {
                                        System.out.println("Empréstimo não encontrado!");
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.print("Digite o nome do leitor: ");
                                    String name = sc.nextLine();
                                    Reader reader = readerService.searchByName(name);
                                    if(reader != null) {
                                        List<Loan> loans = loanService.searchByReader(reader);
                                        if(loans.isEmpty()) {
                                            System.out.println("Nenhum empréstimo encontrado!");
                                        } else {
                                            for(Loan loan: loans) {
                                                System.out.println(loan);
                                            }
                                        }
                                    } else {
                                        System.out.println("Leitor não encontrado!");
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.print("Digite o ISBN do livro: ");
                                    String isbn = sc.nextLine();
                                    Book book = bookService.searchBookByISBN(isbn);
                                    if(book != null) {
                                        Loan loan = loanService.searchByBook(book);
                                        if(loan != null) {
                                            System.out.println(loan);
                                        } else {
                                            System.out.println("Nenhum empréstimo encontrado para esse livro!");
                                        }
                                    } else {
                                        System.out.println("Livro não encontrado!");
                                    }
                                    break;
                                }
                                case 4: {
                                    System.out.print("Digite a data de empréstimo (yyyy-MM-dd): ");
                                    LocalDate loanDate = LocalDate.parse(sc.nextLine());
                                    List<Loan> loans = loanService.searchByLoanDate(loanDate);
                                    if(loans.isEmpty()) {
                                        System.out.println("Nenhum empréstimo encontrado!");
                                    } else {
                                        loans.forEach(System.out::println);
                                    }
                                    break;
                                }
                                case 5: {
                                    System.out.print("Digite a data prevista de devolução (yyyy-MM-dd): ");
                                    LocalDate expectedReturnDate = LocalDate.parse(sc.nextLine());
                                    List<Loan> loans = loanService.searchByExpectedReturnDate(expectedReturnDate);
                                    if(loans.isEmpty()) {
                                        System.out.println("Nenhum empréstimo encontrado!");
                                    } else {
                                        loans.forEach(System.out::println);
                                    }
                                    break;
                                }
                                case 6: {
                                    System.out.print("Digite a data de devolução (yyyy-MM-dd): ");
                                    LocalDate returnDate = LocalDate.parse(sc.nextLine());
                                    List<Loan> loans = loanService.searchByReturnDate(returnDate);
                                    if(loans.isEmpty()) {
                                        System.out.println("Nenhum empréstimo encontrado!");
                                    } else {
                                        loans.forEach(System.out::println);
                                    }
                                    break;
                                }
                                default:
                                    break;
                            }
                            break;
                        }
                    }

                    break;
                }
                default:
                    return;

            }
        }
    }
}
