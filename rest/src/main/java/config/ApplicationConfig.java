package config;


import game.db.WorldDbJpa;
import game.db.WorldDbLocal;
import game.domain.GameService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {

    @Bean
    public GameService service() {
        return new GameService(new WorldDbJpa());
    }//TODO

    /*@Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validationMessages");
        return messageSource;
    }*/

}
