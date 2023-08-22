package br.edu.infnet.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CepTp1Application {

	public static void main(String[] args) {
		SpringApplication.run(CepTp1Application.class, args);
	}

}
