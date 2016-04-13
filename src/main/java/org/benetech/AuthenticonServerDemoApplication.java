package org.benetech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@EnableAutoConfiguration
@SpringBootApplication
public class AuthenticonServerDemoApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticonServerDemoApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AuthenticonServerDemoApplication.class);
    }
}
