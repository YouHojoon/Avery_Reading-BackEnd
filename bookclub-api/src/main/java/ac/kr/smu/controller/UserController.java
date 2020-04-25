package ac.kr.smu.controller;

import ac.kr.smu.domain.User;
import ac.kr.smu.repository.UserRepository;
import ac.kr.smu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
