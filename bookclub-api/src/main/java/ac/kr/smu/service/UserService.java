package ac.kr.smu.service;

import ac.kr.smu.domain.User;
import ac.kr.smu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository=userRepository;}

    public void register(User user){
        user.setPasswd(encodePassword(user.getPasswd()));
        userRepository.save(user);
    }
    private String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
