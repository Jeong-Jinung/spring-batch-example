package fastcampus.spring.batch.springbatchexample.part1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class HelloConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public HelloConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job helloJob() { // 스프링배치의 실행 단위
        return jobBuilderFactory.get("helloJob") // job 이름
            .incrementer(new RunIdIncrementer()) // 항상 job이 실행할때마다 파라미터 아이디를 자동으로 생성
            .start(this.helloStep()) // 최초로 실행될 step을 지정하는 메소드
            .build();
    }

    @Bean
    public Step helloStep() { // Job의 실행 단위
        return stepBuilderFactory.get("helloJob")
            .tasklet((contribution, chunkContext) -> { // tsklet step 의 실행 단위
                log.info("hello spring batch");
                return RepeatStatus.FINISHED;
            }).build();

    }

}
