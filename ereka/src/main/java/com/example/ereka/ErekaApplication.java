package com.example.ereka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableEurekaServer
public class ErekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErekaApplication.class, args);
	}

}
