package com.example.store.repository;

import com.example.store.entity.ActivityHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcitvityHistoryRepository extends JpaRepository<ActivityHistory, Integer> {

    List<ActivityHistory> findHistoryByUserId(String userId);
}
