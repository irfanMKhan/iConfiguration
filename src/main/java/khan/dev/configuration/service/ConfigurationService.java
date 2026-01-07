package khan.dev.configuration.service;

import khan.dev.configuration.model.Configuration;
import khan.dev.configuration.processor.ReadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConfigurationService {

    private final ReadFile readFile;

    public Configuration getConfiguration() throws IOException {
        return readFile.load();
    }

    public Configuration.Application getApplicationConfiguration(String aName) throws IOException {

        Configuration configuration = getConfiguration();
        Optional<Configuration.Application> ca = configuration.getApplication().stream()
                .filter(application -> aName.equals(application.getName()))
                .findFirst();

        return ca.orElse(null);
    }

    public Configuration.Database getApplicationDB_Configuration(String aName) throws IOException {

        Configuration configuration = getConfiguration();
        Optional<Configuration.Application> ca = configuration.getApplication().stream()
                .filter(application -> aName.equals(application.getName()))
                .findFirst();

        return ca.map(Configuration.Application::getDatabase).orElse(null);
    }

}
