package fastcampus.spring.batch.springbatchexample;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FastcampusSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastcampusSpringBatchApplication.class, args);
    }

}
