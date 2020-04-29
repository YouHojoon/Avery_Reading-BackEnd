package ac.kr.smu.controller;

import ac.kr.smu.domain.User;
import ac.kr.smu.service.GroupService;
import ac.kr.smu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity<?> patchUser(@RequestBody Map<String, String> json){//유저 그룹 가입
        userService.setGroup(groupService.findByCode(json.get("code")));
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
}
