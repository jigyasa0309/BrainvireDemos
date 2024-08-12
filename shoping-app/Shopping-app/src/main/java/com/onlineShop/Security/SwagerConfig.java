package com.onlineShop.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwagerConfig implements WebMvcConfigurer {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("E-Commerce Application").description("Backend APIs for E-Commerce app")
						.version("v1.0.0"))
				.externalDocs(new ExternalDocumentation().description("E-Commerce App Documentation")
						.url("http://localhost:8087/swagger-ui/index.html"));
	}
}
