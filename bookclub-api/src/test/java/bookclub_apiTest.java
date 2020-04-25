import ac.kr.smu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class bookclub_apiTest {
    private TestRestTemplate testRestTemplate;
    @Test
    public void register(){
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        User user=User.builder().id("dbghwns11").passwd(passwordEncoder.encode("1111"))
                .email("dbghwns66@daum.net").name("유호준").build();
        testRestTemplate.postForObject("http://localhost:8080/users",user,User.class);
    }
}
