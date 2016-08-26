package kr.co.nanalog;

import kr.co.nanalog.api.web.diary.DiaryController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

//@EnableResourceServer
@SpringBootApplication
public class NanalogApiApplication extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NanalogApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (args) -> {
			FileSystemUtils.deleteRecursively(new File(DiaryController.imageRoot));

			Files.createDirectory(Paths.get(DiaryController.imageRoot));
		};
	}

	/*
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
	*/
}
