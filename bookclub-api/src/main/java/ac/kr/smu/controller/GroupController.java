package ac.kr.smu.controller;

import ac.kr.smu.domain.Group;
import ac.kr.smu.service.GroupService;
import ac.kr.smu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postGroup(@RequestBody Group group){
        groupService.register(group);
        userService.setGroup(group);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
