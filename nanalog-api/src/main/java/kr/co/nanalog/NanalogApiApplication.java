package kr.co.nanalog;

import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@SpringBootApplication
public class NanalogApiApplication extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NanalogApiApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		ComponentRepository componentRepository = context.getBean(ComponentRepository.class);
		DiaryRepository diaryRepository = context.getBean(DiaryRepository.class);
		PageRepository pageRepository = context.getBean(PageRepository.class);

	}

	@Bean
	public ResourceServerConfigurerAdapter resourceServerConfigurerAdapter() {
		return new ResourceServerConfigurerAdapter() {
			@Override
			public void configure(HttpSecurity http) throws Exception {
				http.headers().frameOptions().disable();
				http.authorizeRequests().antMatchers("/api/**").authenticated();
			}
		};
	}
}
