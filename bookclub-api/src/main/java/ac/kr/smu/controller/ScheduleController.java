package ac.kr.smu.controller;

import ac.kr.smu.domain.Schedule;
import ac.kr.smu.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping
    public ResponseEntity<?> postSchedule(@RequestBody Schedule schedule){
        scheduleService.register(schedule);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
