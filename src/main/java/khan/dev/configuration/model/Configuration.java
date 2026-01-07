package khan.dev.configuration.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Configuration {
    private String version;
    private List<Application> application;

    @Getter
    @Setter
    public static class Database {
        private String url;
        private String username;
        private String password;
        private String port;
        private String databaseName;
        private String encrypt;
        private String trustServerCertificate;
        private String driverClassName;
    }

    @Getter
    @Setter
    public static class Persistence {
        private String ddl;
    }

    @Getter
    @Setter
    public static class Application {
        private String name;
        private Database database;
        private Persistence persistence;
    }

}
