package tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import tracker.services.ScheduledGPSService;
import tracker.services.ScheduledSendService;
import tracker.services.ScheduledStorageService;

@Configuration
@ComponentScan
@PropertySource("classpath:/tracker-core.properties")
@EnableScheduling
public class TrackerContext {

    @Bean
    public ScheduledGPSService scheduledGPSService() {
        return new ScheduledGPSService();
    }

    @Bean
    public ScheduledStorageService scheduledStorageService() {
        return new ScheduledStorageService();
    }

    @Bean
    public ScheduledSendService scheduledSendService() {
        return new ScheduledSendService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("trackerPoolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
