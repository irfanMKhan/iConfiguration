package khan.dev.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IConfigurationApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(IConfigurationApplication.class, args);
    }

}
