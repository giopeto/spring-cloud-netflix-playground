package com.hystrixclientservice.hystrixclientservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixClientServiceApplication.class, args);
	}

	@Bean
	Sampler sampler() {
		return new Sampler() {
			@Override
			public boolean isSampled(long traceId) {
				return true	;
			}
		};
	}
}
