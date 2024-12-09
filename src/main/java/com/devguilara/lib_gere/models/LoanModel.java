package com.devguilara.lib_gere.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LoanModel {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /*
    * LoanModel tem uma relação de muitos para um com UserModel e BookModel, ou seja,
    * um empréstimo pode ter um único usuário e um único livro.
    * */
    @ManyToOne
    private UserModel user;

    @ManyToOne
    private BookModel book;


    private LocalDate loanDate;
    private LocalDate returnDate;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public BookModel getBook() {
        return book;
    }
    public void setBook(BookModel book) {
        this.book = book;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
