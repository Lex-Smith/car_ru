package org.javaacademy.car_ru.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Value;


@Value
public class AdDto {
    String adID;
    String brand;
    String color;
    BigDecimal price;
    String model;
    LocalDate date;
}