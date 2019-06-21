package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "core","controller"} ) 
public class BuildJavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildJavaProjectApplication.class, args);
		System.out.println("Spring Boot Application Started...");
	}

}
