package ac.kr.smu.service;

import ac.kr.smu.domain.User;
import ac.kr.smu.domain.enums.UserRole;
import ac.kr.smu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(User user){
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
    }


}
