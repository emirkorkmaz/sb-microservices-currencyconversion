package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.proxy")
@EnableDiscoveryClient
public class SbMicroservicesCurrencyconversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroservicesCurrencyconversionApplication.class, args);
	}
}
