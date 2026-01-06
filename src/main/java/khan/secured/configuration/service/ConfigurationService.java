package khan.secured.configuration.service;

import khan.secured.configuration.model.Configuration;
import khan.secured.configuration.processor.ReadFile;
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

    public Configuration.Application getConfiguration(String aName) throws IOException {

        Configuration configuration = getConfiguration();
        Optional<Configuration.Application> ca = configuration.getApplication().stream()
                .filter(application -> aName.equals(application.getName()))
                .findFirst();

        return ca.orElse(null);
    }

}
