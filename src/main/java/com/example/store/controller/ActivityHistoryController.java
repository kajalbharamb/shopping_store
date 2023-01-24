package com.example.store.controller;
import com.example.store.dto.response.ActivityResponse;
import com.example.store.entity.ActivityHistory;
import com.example.store.service.ActivityHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityHistoryController {

    @Autowired
    private ActivityHistoryService acitivityHistoryService;

    @GetMapping("/list")
    public ResponseEntity<ActivityResponse> getActivityList(){
        return new ResponseEntity<>(new ActivityResponse(HttpStatus.OK.value(),"List of activity",acitivityHistoryService.getActivityHistory()),HttpStatus.OK);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<ActivityResponse> getActivityListByUserId(@PathVariable String userId){
        return new ResponseEntity<>(new ActivityResponse(HttpStatus.OK.value(),"Activity list by "+userId,acitivityHistoryService.getActivityHistoryByUserId(userId)), HttpStatus.OK) ;
    }
}
