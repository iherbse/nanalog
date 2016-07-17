package kr.co.nanalog;

import kr.co.nanalog.api.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NanalogApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NanalogApiApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
	}
}
