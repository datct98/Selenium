package com.example.buoi5_jpa.repository;

import com.example.buoi5_jpa.model.Clasz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Clasz, Integer> {
    Clasz findById(int id);
}
