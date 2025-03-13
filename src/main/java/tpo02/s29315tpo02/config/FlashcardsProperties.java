package tpo02.s29315tpo02.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pl.edu.pja.tpo02")
public class FlashcardsProperties {
    private String filename;
    public String getFilename() {return filename;}
    public void setFilename(String filename) {this.filename = filename;}
}
