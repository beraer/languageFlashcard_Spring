package tpo02.s29315tpo02;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tpo02.s29315tpo02.controller.FlashcardsController;

public class FlashcardsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);
        FlashcardsController controller = context.getBean(FlashcardsController.class);
        controller.run();
    }
}
