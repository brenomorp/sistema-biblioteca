# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java puro, sem frameworks externos, seguindo o padrão arquitetural MVC.

## 📋 Funcionalidades

- Cadastro, remoção e busca de livros
- Cadastro, remoção e busca de leitores
- Registro de empréstimos com data prevista de devolução
- Devolução de livros com detecção de atraso
- Validação de limite de livros por leitor
- Histórico completo de empréstimos
- Busca de empréstimos por leitor, livro e data

## 🏗️ Arquitetura

O projeto segue o padrão **MVC (Model-View-Service)**:

```
src/
└── main/
    └── java/
        └── com.breno.librarysystem/
            ├── model/
            │   ├── Book.java
            │   ├── Reader.java
            │   └── Loan.java
            ├── service/
            │   ├── BookService.java
            │   ├── ReaderService.java
            │   └── LoanService.java
            ├── view/
            │   └── Menu.java
            └── Main.java
```

| Camada | Responsabilidade |
|--------|-----------------|
| `model` | Entidades do sistema |
| `service` | Regras de negócio |
| `view` | Interface com o usuário |

## 🛠️ Tecnologias

- Java 17+
- API de datas (`LocalDate`, `Year`)
- Coleções (`List`, `ArrayList`)

## ▶️ Como executar

**Pré-requisitos:** Java 17 ou superior instalado.

Clone o repositório:
```bash
git clone https://github.com/brenomorp/sistema-biblioteca.git
```

Acesse a pasta do projeto:
```bash
cd sistema-biblioteca
```

Compile o projeto:
```bash
javac -d out src/main/java/com/breno/librarysystem/**/*.java src/main/java/com/breno/librarysystem/Main.java
```

Execute:
```bash
java -cp out com.breno.librarysystem.Main
```

## 📖 Como usar

Ao iniciar o sistema, um menu principal será exibido com três opções:

```
MENU PRINCIPAL:
1 - Gerenciar leitores
2 - Gerenciar livros
3 - Gerenciar Empréstimos
0 - Sair
```

Cada opção abre um submenu com as ações disponíveis para aquela área.

## 📌 Regras de negócio

- Cada leitor possui um limite máximo de livros que pode ter emprestado simultaneamente
- A data prevista de devolução é definida automaticamente como 30 dias após o empréstimo
- O sistema detecta e informa quando um livro é devolvido com atraso
- O histórico de empréstimos é mantido mesmo após a devolução
- Não é possível registrar empréstimo de um livro que já está emprestado

## 🗂️ Padrão de commits

O projeto segue o padrão [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: add nova funcionalidade
fix: corrigir bug
chore: configurações e ajustes
docs: documentação
refactor: refatoração sem mudança de comportamento
test: testes
```
