package com.data.springboot_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {//CrudRepository<Alert, Long> {
    //List<Alert> findByName(String name);
    @Query("select x.name from Alert x")
    List<String> getAllNames();
}

