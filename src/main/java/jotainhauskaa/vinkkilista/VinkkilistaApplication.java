package jotainhauskaa.vinkkilista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {""}) 
public class VinkkilistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinkkilistaApplication.class, args);
	}
}
