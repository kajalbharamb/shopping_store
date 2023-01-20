package com.example.store.controller;
import com.example.store.entity.ActivityHistory;
import com.example.store.service.ActivityHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/activityList")
public class ActivityHistoryController {

    @Autowired
    private ActivityHistoryService acitivityHistoryService;

    @GetMapping("/list")
    public ResponseEntity<List<ActivityHistory>> getActivityList(){
        return new ResponseEntity<>(acitivityHistoryService.getActivityHistory(), HttpStatus.OK) ;
    }

    @PostMapping("/list/{userId}")
    public ResponseEntity<List<ActivityHistory>> getActivityListByUserId(@PathVariable String userId){
        return new ResponseEntity<>(acitivityHistoryService.getActivityHistoryByUserId(userId), HttpStatus.OK) ;
    }
}
