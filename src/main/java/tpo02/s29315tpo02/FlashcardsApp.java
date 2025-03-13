package tpo02.s29315tpo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tpo02.s29315tpo02.controller.FlashcardsController;
import tpo02.s29315tpo02.service.FileService;

@SpringBootApplication(scanBasePackages = "tpo02.s29315tpo02")
public class FlashcardsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);
        FileService fileService = context.getBean(FileService.class);
        fileService.loadEntriesFromFile();

        FlashcardsController controller = context.getBean(FlashcardsController.class);
        controller.run();
    }
}
