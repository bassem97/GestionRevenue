package com.spring.gestionrevenue.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Result implements Serializable {
    private String month;
    private Float revenue;

    public Result(String month, Float revenue) {
        this.month = month;
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Result{" +
                "month='" + month + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
