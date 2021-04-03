package com.minesweeperAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
@EnableSwagger2
public class MinesweeperApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApiApplication.class, args);
	}

}
