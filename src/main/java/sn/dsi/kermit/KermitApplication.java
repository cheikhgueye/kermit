package sn.dsi.kermit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
@EnableSwagger2
@SpringBootApplication

@EntityScan(basePackageClasses = {
		KermitApplication.class,
		Jsr310JpaConverters.class
})
public class KermitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KermitApplication.class, args);
	}
	


@Bean
public Docket Api() {
    return new Docket(DocumentationType.SWAGGER_2)
    	 .host("http://localhost:8081")
         .select()
            .apis(RequestHandlerSelectors.basePackage("sn.dsi.kermit.controller"))
            .paths(PathSelectors.any()).build().pathMapping("/")
            .apiInfo(apiInfo()).useDefaultResponseMessages(false);
      
}

	   @Bean
	   ApiInfo apiInfo() {
	       final ApiInfoBuilder builder = new ApiInfoBuilder();
	       builder.title("kermit API").version("1.0").license("(C) Copyright KesrmitApp")
	               .description("kermit...");
	       return builder.build();
	   }
}
