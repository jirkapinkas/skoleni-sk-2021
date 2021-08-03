package com.example.demo;

import org.fluentd.logger.FluentLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    private static FluentLogger log = FluentLogger.getLogger("myapp", "fluentd", 24224);

    @PreDestroy
    public void destroy() {
        log.close();
    }

    @Scheduled(fixedDelay = 1_000)
    public void run() {
        {
            Map<String, Object> data = new HashMap<>();
            data.put("message", "App is running");
            data.put("timestamp", String.valueOf(LocalDateTime.now()));
            log.log("follow", data);
        }
//        {
//            Map<String, Object> data = new HashMap<>();
//            data.put("message", "App is running (not filtered)");
//            data.put("timestamp", String.valueOf(LocalDateTime.now()));
//            log.log("follow", data);
//        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
