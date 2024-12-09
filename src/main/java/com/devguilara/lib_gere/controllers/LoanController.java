package com.devguilara.lib_gere.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import com.devguilara.lib_gere.DTO.LoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devguilara.lib_gere.Repository.LoanRepository;
import com.devguilara.lib_gere.Repository.BookRepository;
import com.devguilara.lib_gere.Repository.UserRepository;
import com.devguilara.lib_gere.models.BookModel;
import com.devguilara.lib_gere.models.LoanModel;
import com.devguilara.lib_gere.models.UserModel;


@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public java.util.List<LoanModel> listAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanModel> getLoanById(@PathVariable Long id){
        if(loanRepository.existsById(id)) {
            LoanModel loan = loanRepository.findById(id).get();
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/availability/{bookId}")
    public ResponseEntity<LoanDTO> checkBookAvailability(@PathVariable Long bookId) {
        BookModel book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso o livro não seja encontrado
        }

        boolean isAvailable = !loanRepository.existsByBookIdAndReturnDateAfter(bookId, LocalDate.now());

        // Cria o DTO para resposta
        LoanDTO loanDTO = new LoanDTO(book.getTitulo(), isAvailable);

        return ResponseEntity.ok(loanDTO);
    }

    @PostMapping
    public ResponseEntity<LoanModel> registerLoan(@RequestParam Long usuarioId, @RequestParam Long livroId) {
        // Verifica se o usuário existe
        UserModel usuario = userRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 caso o usuário não seja encontrado
        }

        // Verifica se o livro existe
        BookModel livro = bookRepository.findById(livroId).orElse(null);
        if (livro == null) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 caso o livro não seja encontrado
        }

        // Caso as verificações acima deem 200(OK)

        // Cria um novo objeto de empréstimo(loan)
        LoanModel loan = new LoanModel();
        loan.setUser(usuario);
        loan.setBook(livro);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(7)); // Define a data de devolução como 7 dias após o empréstimo

        // Salva o empréstimo no banco de dados e retorna a resposta com o status 201 (Created)
        LoanModel savedLoan = loanRepository.save(loan);
        return ResponseEntity.status(201).body(savedLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanModel> updateDateLoan(@PathVariable Long id){
        LoanModel loan = loanRepository.findById(id).orElse(null);
        if(loan == null){
            return ResponseEntity.badRequest().body(null);
        }
        loan.setReturnDate(LocalDate.now().plusDays(30));
        // Dia de Hoje + 7 dias
        loanRepository.save(loan);
        return ResponseEntity.ok(loan);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
        
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
            
        }
    }
}
