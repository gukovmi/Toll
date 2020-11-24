package tracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TrackerMain {
    public static void main(String... args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(TrackerContext.class);
    }
}
