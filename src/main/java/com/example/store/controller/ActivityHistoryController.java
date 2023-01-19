package com.example.store.controller;
import com.example.store.entity.ActivityHistory;
import com.example.store.service.ActivityHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activityList")
public class ActivityHistoryController {

    @Autowired
    private ActivityHistoryService acitivityHistoryService;

    @GetMapping("/list")
    public List<ActivityHistory> getActivityList(){
        return acitivityHistoryService.getActivityHistory();
    }

    @PostMapping("/list/{userId}")
    public List<ActivityHistory> getActivityListByUserId(@PathVariable String userId){
        return acitivityHistoryService.getActivityHistoryByUserId(userId);
    }
}
