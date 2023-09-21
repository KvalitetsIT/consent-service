package dk.kvalitetsit.consentservice.configuration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FlywayConfiguration {

	@Value("${dataSource.driverClassName}")
	private String databaseType;

	@Value("${FLYWAY_PLACEHOLDERS_MUNICIPALITY}")
    private String municipality;

	@Bean(initMethod = "migrate")
	public Flyway flyway(DataSource dataSource) {
		Map<String, String> placeholders = getPlaceholders();

		return Flyway
				.configure()
				.dataSource(dataSource)
				.locations("db/migration/")
				.placeholders(placeholders).load();
	}

    private Map<String, String> getPlaceholders() {
        Map<String,String> placeholders = new HashMap<>();
        placeholders.put("MUNICIPALITY",municipality);
        return placeholders;
    }
}