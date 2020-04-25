package ac.kr.smu;

import ac.kr.smu.event.UserEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ac.kr.smu.domain")
@EnableJpaRepositories("ac.kr.smu.repository")
public class BookclubApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }

}
