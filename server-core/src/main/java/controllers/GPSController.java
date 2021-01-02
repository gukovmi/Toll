package controllers;

import models.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class GPSController {

    private static final Logger log = LoggerFactory.getLogger(GPSController.class);
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/gps", method = RequestMethod.POST)
    public Response setPoints(@RequestBody ArrayList<String> points) {
        points.forEach(log::info);
        return new Response("ok", true);
    }
}
