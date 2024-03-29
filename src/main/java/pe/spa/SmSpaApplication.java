package pe.spa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmSpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmSpaApplication.class, args);
	}

}
