package com.gorbatenko.palindrome.repository;

import com.gorbatenko.palindrome.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HistoryRepository extends JpaRepository<History, Integer> {
    @Query("SELECT h.dateTime, h.numValue FROM History h WHERE h.user.id = :userId ORDER BY h.dateTime DESC")
    List<History> getByUserIdSOrderByDateTimeDesc(@Param("userId")int userId);
}