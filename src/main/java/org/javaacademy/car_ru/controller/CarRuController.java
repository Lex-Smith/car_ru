package org.javaacademy.car_ru.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javaacademy.car_ru.dto.AdDto;
import org.javaacademy.car_ru.entity.Ad;
import org.javaacademy.car_ru.service.AdService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/carru")
@RequiredArgsConstructor
public class CarRuController {

    private final AdService adService;

    @PostMapping
    public void createAd(@RequestBody AdDto body) {
        adService.createAd(body);
    }

    @GetMapping("/date")
    public List<Ad> getAdsByDate(@RequestParam LocalDate date) {
        return adService.getAdsByDate(date);
    }

    @DeleteMapping
    public void deleteAdByID(@RequestParam String adID) {
        adService.deleteAdByID(adID);
    }

    @GetMapping("/param")
    public List<Ad> getAdByParams(@RequestParam(required = false) String brand,
                              @RequestParam(required = false) String color,
                              @RequestParam(required = false) BigDecimal price,
                              @RequestParam(required = false) String model) {
        return adService.getAdByParams(brand, color, price, model);
    }

    @GetMapping("/adID")
    public Ad getAdByID(@RequestParam String adID) {
        return adService.getAdByID(adID);
    }
}