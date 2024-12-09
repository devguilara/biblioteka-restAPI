package com.devguilara.lib_gere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devguilara.lib_gere.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}
