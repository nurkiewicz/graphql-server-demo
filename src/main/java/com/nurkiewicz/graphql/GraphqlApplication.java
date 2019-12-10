package com.nurkiewicz.graphql;

import brave.sampler.Sampler;
import com.devskiller.jfairy.Fairy;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	@Bean
	ExecutorService billingExecutor(BeanFactory beanFactory) {
		return new TraceableExecutorService(beanFactory, Executors.newFixedThreadPool(10), "Billing");
	}

	@Bean
	ExecutorService pointsExecutor(BeanFactory beanFactory) {
		return new TraceableExecutorService(beanFactory, Executors.newFixedThreadPool(10), "Points");
	}

	@Bean
	ExecutorService playerExecutor(BeanFactory beanFactory) {
		return new TraceableExecutorService(beanFactory, Executors.newFixedThreadPool(10), "Player");
	}

	@Bean
	ExecutorService inventoryExecutor(BeanFactory beanFactory) {
		return new TraceableExecutorService(beanFactory, Executors.newFixedThreadPool(10), "Inventory");
	}

}
