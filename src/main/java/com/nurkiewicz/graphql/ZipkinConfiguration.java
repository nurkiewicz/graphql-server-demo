package com.nurkiewicz.graphql;

import brave.sampler.Sampler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

@Configuration
@ConditionalOnProperty(value = "spring.sleuth.enabled", matchIfMissing = true)
public class ZipkinConfiguration {

    @Bean
    Reporter reporter() {
        return AsyncReporter.create(OkHttpSender.create("http://localhost:9411/api/v2/spans"));
    }

    @Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
