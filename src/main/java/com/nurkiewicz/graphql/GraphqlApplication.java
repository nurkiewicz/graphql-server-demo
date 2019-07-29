package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	Fairy fairy() {
		return Fairy.create();
	}

}
