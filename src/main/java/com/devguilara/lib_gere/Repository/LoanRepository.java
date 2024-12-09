package com.devguilara.lib_gere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devguilara.lib_gere.models.LoanModel;

import java.time.LocalDate;

@Repository
public interface LoanRepository extends JpaRepository<LoanModel, Long>{

    boolean existsByBookIdAndReturnDateAfter(Long bookId, LocalDate returnDate);

}
