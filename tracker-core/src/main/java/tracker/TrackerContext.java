package tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;
import tracker.services.GPSService;
import tracker.services.SendService;
import tracker.services.StorageService;

@Configuration
@PropertySource("classpath:/tracker-core.properties")
@EnableScheduling
public class TrackerContext {

    @Bean
    public GPSService gpsService() {
        return new GPSService();
    }
    @Bean
    public StorageService storageService() {
        return new StorageService();
    }
    @Bean
    public SendService sendService() {
        return new SendService();
    }
    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("trackerPoolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
