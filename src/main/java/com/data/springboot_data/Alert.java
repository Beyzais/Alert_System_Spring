package com.data.springboot_data;

import org.springframework.http.HttpMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private String httpMethod ;
    private Integer period;
    private Integer status ;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer periyot) {
        this.period = periyot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Alert(Long id, String name, String url, String httpMetot, Integer periyot,  Integer state) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.httpMethod = httpMetot;
        this.period = periyot;
        this.status = state;

    }
    public Alert(){};

    public Alert(String name, String url, String httpMetot, Integer periyot, Integer state) {
        this.name = name;
        this.url = url;
        this.httpMethod = httpMetot;
        this.period = periyot;
        this.status = state;
    }


}