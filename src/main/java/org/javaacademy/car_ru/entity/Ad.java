package org.javaacademy.car_ru.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.NonNull;

@Data
public class Ad {
    @NonNull
    private String adID;
    @NonNull
    private String brand;
    @NonNull
    private String color;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String model;
    @NonNull
    private LocalDate date;
}