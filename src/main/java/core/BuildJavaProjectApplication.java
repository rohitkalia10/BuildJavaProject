package core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages = { "core","controller","model", "data","schema", "util","impl"} )
public class BuildJavaProjectApplication {
	private static final Logger logger = LogManager.getLogger(BuildJavaProjectApplication.class);

public static void main(String[] args) {

		SpringApplication.run(BuildJavaProjectApplication.class, args);
		logger.info("Spring Boot Application Started...");

	}
}
