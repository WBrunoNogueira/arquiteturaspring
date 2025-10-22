package io.github.cursodsousa.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(ArquiteturaspringApplication.class, args);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

        builder.run(args);

        //contexto da applicação já iniciado

        builder.bannerMode(Banner.Mode.OFF); // off banner spring
        ConfigurableApplicationContext applicationContext = builder.context();
     //   var produtoRepository = applicationContext.getBean("produtoRepository");

        //builder.properties("spring.datasource.url=jdbc://"); //inserir properties logo na inicialização, ao invez do yaml ou .properties

        builder.profiles("produção");

    builder.profiles("produção");

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String applicationname = environment.getProperty("spring.application.name");
        System.out.println("Nome da applicação: " + applicationname);


    }

}
