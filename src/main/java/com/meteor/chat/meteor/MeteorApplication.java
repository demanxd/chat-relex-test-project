package com.meteor.chat.meteor;

import com.meteor.chat.meteor.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MeteorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteorApplication.class, args);
	}

}
