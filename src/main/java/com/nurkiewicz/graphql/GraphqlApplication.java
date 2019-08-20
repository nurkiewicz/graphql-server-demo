package com.nurkiewicz.graphql;

import brave.sampler.Sampler;
import com.devskiller.jfairy.Fairy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	Fairy fairy() {
		return Fairy.create();
	}

	@Bean
	Reporter reporter() {
		return AsyncReporter.create(OkHttpSender.create("http://localhost:9411/api/v2/spans"));
	}

	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
