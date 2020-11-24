package tracker.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SendService {

    private static final Logger log = LoggerFactory.getLogger(SendService.class);

    @Autowired
    private StorageService storageService;

    @Scheduled(fixedRateString = "${sendingPeriod.prop}", initialDelayString = "${initialDelay.prop}")
    public void takeAll() throws InterruptedException {
        send(storageService.takeAll());
    }

    public void send(ArrayList<String> points) {
        points.forEach(log::info);
    }
}
