package com.data.springboot_data.Request;


import com.data.springboot_data.Alert;
import com.data.springboot_data.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@EnableAsync
@Service
public class ApplyPeriod {
    private static int counter = 0;
    private SendRequest req = new SendRequest();
    @Autowired
    private AlertRepository repo;

    @Scheduled(fixedDelay = 1000)
    public void control_Period() throws IOException {

        counter++;
        List<Alert> Alerts = repo.findAll();

        for(Alert alert: Alerts ) {
            if (counter % alert.getPeriod() == 0) {
                req.getConnection(alert);
                System.out.println(alert.getName() + " için Get req. gönderildi.. " + counter);
            }

        }
    }
}
