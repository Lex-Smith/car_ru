package org.javaacademy.car_ru.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import org.javaacademy.car_ru.dto.AdDto;
import org.javaacademy.car_ru.entity.Ad;
import org.javaacademy.car_ru.repository.AdRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    AtomicLong counter = new AtomicLong();

    private String carIDGenerator() {
        long numericID = counter.getAndIncrement();
        return String.valueOf(numericID);
    }

    public void createAd(AdDto dto) {
        Ad ad = new Ad(carIDGenerator(),
                dto.getBrand(),
                dto.getColor(),
                dto.getPrice(),
                dto.getModel(),
                dto.getDate());
        adRepository.addAd(ad);
    }

    public List<Ad> getAdsByDate(LocalDate date) {
        return adRepository.getAdsByDate(date);
    }

    public void deleteAdByID(String adID) {
        adRepository.deleteAdByID(adID);
    }

    public Ad getAdByID(String adID) {
        return adRepository.getAdByID(adID);
    }

    public List<Ad> getAdByParams(String brand, String color, BigDecimal price, String model) {
        return adRepository.getAdByParams(brand, color, price, model);
    }
}