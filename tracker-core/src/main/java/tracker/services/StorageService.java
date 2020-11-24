package tracker.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service("scheduledStorageService")
public class StorageService {

    private final BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);

    public void put(String point) throws InterruptedException {
        queue.put(point);
    }

    public ArrayList<String> takeAll() throws InterruptedException {
        ArrayList<String> messageArray = new ArrayList<>();
        while (!queue.isEmpty()) {
            messageArray.add(queue.take());
        }
        return messageArray;
    }
}
