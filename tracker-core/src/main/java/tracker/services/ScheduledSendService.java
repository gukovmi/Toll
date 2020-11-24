package tracker.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ScheduledSendService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledSendService.class);

    @Autowired
    private ScheduledStorageService scheduledStorageService;

    @Scheduled(fixedRateString = "${sendingPeriod.prop}", initialDelayString = "${initialDelay.prop}")
    public void takeAll() throws InterruptedException {
        send(scheduledStorageService.takeAll());
    }

    public void send(ArrayList<String> points) {
        points.forEach(log::info);
    }
}
