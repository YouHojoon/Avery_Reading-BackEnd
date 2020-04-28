package ac.kr.smu.service;

import ac.kr.smu.config.jwt.JwtTokenProvider;
import ac.kr.smu.domain.Group;
import ac.kr.smu.domain.User;
import ac.kr.smu.domain.enums.UserRole;
import ac.kr.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void register(User user){
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }
    public void setManager(User user){
        user.setRole(UserRole.MANAGER);
    }
    public void setGroup(Group group){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String token=request.getHeader("X-AUTH-TOKEN");
        Long uid=Long.valueOf(jwtTokenProvider.getUid(token));
        User user= userRepository.getOne(uid);
        user.setGroup(group);
        if(request.getServletPath().contains("/groups") && request.getMethod().equals("POST"))
            user.setRole(UserRole.MANAGER);
        userRepository.save(user);
    }
}
