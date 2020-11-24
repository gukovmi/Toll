package tracker.services;

import dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ScheduledGPSService {

    @Autowired
    private ScheduledStorageService scheduledStorageService;

    @Scheduled(fixedRateString = "${gettingPeriod.prop}")
    public void getPoint() throws Exception {
        PointDTO point = new PointDTO(
                "о777оо70",
                new Random().nextDouble() * 180 - 90,
                new Random().nextDouble() * 360 - 180,
                new Random().nextDouble() * 360,
                new Random().nextInt(110),
                System.currentTimeMillis());
        sendPoint(point);
    }

    void sendPoint(PointDTO point) throws Exception {
        scheduledStorageService.put(point.toJson());
    }
}
