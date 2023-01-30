package com.example.store.dto.response;

import com.example.store.entity.ActivityHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse extends ApiResponse {
    private List<ActivityHistory> activityHistories;

    public ActivityResponse(int statusCode, String message, List<ActivityHistory> activityHistories) {
        super(statusCode, message);
        this.activityHistories = activityHistories;
    }

    public List<ActivityHistory> getActivityHistories() {
        return activityHistories;
    }

    public void setActivityHistories(List<ActivityHistory> activityHistories) {
        this.activityHistories = activityHistories;
    }
}
