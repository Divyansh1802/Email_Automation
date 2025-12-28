package com.EmailAutomation.UserService.Scheduler;

import com.EmailAutomation.UserService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleUserSTATUS {
    private final UserService userService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void ScheduleUserStatus() {
        userService.UpdateUserSTATUS();
    }
}
