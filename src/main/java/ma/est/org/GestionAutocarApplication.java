package ma.est.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class GestionAutocarApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(GestionAutocarApplication.class, args);
		
	}

}
