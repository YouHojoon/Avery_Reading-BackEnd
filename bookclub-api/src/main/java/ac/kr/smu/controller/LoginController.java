package ac.kr.smu.controller;

import ac.kr.smu.config.jwt.JwtTokenProvider;
import ac.kr.smu.domain.User;
import ac.kr.smu.exception.LoginException;
import ac.kr.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(path="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postLogin(@RequestBody Map<String, String> json){
        User user=userRepository.findById(json.get("id")).orElseThrow(LoginException::new);
        if(!passwordEncoder.matches(json.get("passwd"),user.getPassword()))
            throw new LoginException();
        String token= jwtTokenProvider.createToken(String.valueOf(user.getUid()),user.getRole().getAuthoritie());
        EntityModel<String> resource = new EntityModel<>(token);
        resource.add(linkTo(methodOn(LoginController.class).postLogin(json)).withSelfRel());
        return ResponseEntity.ok(resource);
    }

}
