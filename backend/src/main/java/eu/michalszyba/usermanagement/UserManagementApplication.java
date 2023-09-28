package eu.michalszyba.usermanagement;

import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserManagementApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
}
