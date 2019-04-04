package com.gorbatenko.polindrome.repository;

import com.gorbatenko.polindrome.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
    List<History> getByUserId(int userId);
}