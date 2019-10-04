package com.data.springboot_data.Request;


import com.data.springboot_data.Alert;
import com.data.springboot_data.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendRequest {

    @Async
    public void getConnection(Alert alert) throws IOException {
        URL url = new URL(alert.getUrl());
        System.out.println(alert.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");//alert.getHttpMethod());

        int response = connection.getResponseCode();
        System.out.println(response);
        if(response == 200){
            alert.setStatus(1);
        }
        else{
            alert.setStatus(0);
        }

    }
}