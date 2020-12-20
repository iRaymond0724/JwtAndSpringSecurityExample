package dumbo.com.JwtAndSpringSecurityExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class JwtAndSpringSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAndSpringSecurityExampleApplication.class, args);
	}

}
