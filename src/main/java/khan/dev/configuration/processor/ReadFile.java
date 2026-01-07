package khan.dev.configuration.processor;


import khan.dev.configuration.model.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class ReadFile {

    private final ObjectMapper mapper = new ObjectMapper();

    @Value("classpath:data/configuration.json")
    private Resource resource;

    public Configuration load() throws IOException {
        return mapper.readValue(resource.getInputStream(), Configuration.class);
    }

}
