package com.example.store.service;
import com.example.store.entity.ActivityHistory;
import com.example.store.repository.AcitvityHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ActivityHistoryService {

    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;
    public List<ActivityHistory> getActivityHistory() {
        return acitvityHistoryRepository.findAll();
    }

    public List<ActivityHistory> getActivityHistoryByUserId(String userId) {
        return acitvityHistoryRepository.findHistoryByUserId(userId);
    }
}
