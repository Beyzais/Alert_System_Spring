package com.data.springboot_data;

import com.data.springboot_data.error.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RestController//@Controller
public class AlertController {

    @Autowired
    private AlertRepository repository;
    private Alert alert;

    @GetMapping("/list")
    List<Alert> findAll() {
        return repository.findAll();
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    Alert newOne(@RequestBody Alert newAlert) {
        return repository.save(newAlert);
    }

    @GetMapping("/list/{id}")
    Alert findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ElementNotFoundException(id));

    }

    @GetMapping("/getNames")
    public List<String> getAlertsNames() {
        List<String> liste = new ArrayList<>();
        liste.addAll(repository.getAllNames());
        Collections.sort(liste);
        return liste;

    }

    @GetMapping("/getPeriod/{id}")
    public Integer getPeriod(@PathVariable Long id) {
        alert = findOne(id);

        return alert.getPeriod();
    }

    @GetMapping("/status/{id}")
    public Integer getGraphStatus(@PathVariable Long id) throws IOException {
        alert = findOne(id);

        System.out.println("ad: " + alert.getName());
        return alert.getStatus();
    }


}


