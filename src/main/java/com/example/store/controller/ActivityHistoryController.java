package com.example.store.controller;

import com.example.store.dto.response.ActivityResponse;
import com.example.store.service.ActivityHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityHistoryController {

    @Autowired
    private ActivityHistoryService acitivityHistoryService;

    @GetMapping("/list")
    public ResponseEntity<ActivityResponse> getActivityList() {
        return new ResponseEntity<>(new ActivityResponse(HttpStatus.OK.value(), "List of activity", acitivityHistoryService.getActivityHistory()), HttpStatus.OK);
    }

    @GetMapping("/listByUserId/{userId}")
    public ResponseEntity<ActivityResponse> getActivityListByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(new ActivityResponse(HttpStatus.OK.value(), "Activity list by " + userId, acitivityHistoryService.getActivityHistoryByUserId(userId)), HttpStatus.OK);
    }
}
