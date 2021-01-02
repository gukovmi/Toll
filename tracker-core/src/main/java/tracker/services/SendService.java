package tracker.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@Service
public class SendService {

    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    @Autowired
    private StorageService storageService;
    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRateString = "${sendingPeriod.prop}", initialDelayString = "${initialDelay.prop}")
    public void takeAll() throws InterruptedException {
        send(storageService.takeAll());
    }

    public void send(ArrayList<String> points) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ArrayList<String>> requestEntity = new HttpEntity<ArrayList<String>>(points, headers);
        restTemplate.postForEntity(
                "http://localhost:8080/gps",
                requestEntity,
                String.class);
        points.forEach(log::info);
    }
}
