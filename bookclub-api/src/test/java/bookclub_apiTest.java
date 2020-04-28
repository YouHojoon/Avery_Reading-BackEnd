import ac.kr.smu.domain.Group;
import ac.kr.smu.domain.User;
import ac.kr.smu.service.GroupService;
import ac.kr.smu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@SpringBootTest
@ComponentScan("ac.kr.smu.service")
public class bookclub_apiTest {


    @Test
    @Transactional
    public void register(){

    }
}
