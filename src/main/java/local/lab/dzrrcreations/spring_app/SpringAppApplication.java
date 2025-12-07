package local.lab.dzrrcreations.spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

}

// DEV
// https://localhost:18300/swagger-ui/index.html
// https://localhost:18300/h2


// PRD
// https://localhost:443/swagger-ui/index.html
// https://localhost:443/h2