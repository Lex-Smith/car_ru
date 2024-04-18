package org.javaacademy.car_ru.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.javaacademy.car_ru.entity.Ad;
import org.springframework.stereotype.Component;

@Component
public class AdRepository {

    private List<Ad> ads = new ArrayList<>();

    public void addAd(Ad ad) {
        ads.add(ad);
    }

    public List<Ad> getAdsByDate(LocalDate date) {
        return new ArrayList<>(ads.stream()
                .filter(e -> e.getDate().equals(date))
                .toList());
    }

    public void deleteAdByID(String adID) {
        ads = new ArrayList<>(ads.stream().filter(e -> !e.getAdID().equals(adID)).toList());
    }

    public List<Ad> get() {
        return ads;
    }

    public Ad getAdByID(String adID) {
        return ads.stream().filter(e -> e.getAdID().equals(adID)).findFirst().orElse(null);
    }

    public List<Ad> getAdByParams(String brand, String color, BigDecimal price, String model) {

        List<Ad> resultList;

        if (brand != null) {
            resultList = ads.stream().filter(e -> e.getBrand().equals(brand)).toList();
        } else {
            resultList = ads;
        }
        if (color != null && !resultList.isEmpty()) {
            resultList = resultList.stream().filter(e -> e.getColor().equals(color)).toList();
        } else {
            resultList = ads;
        }
        if (price != null && !resultList.isEmpty()) {
            resultList = resultList.stream().filter(e -> e.getPrice().equals(price)).toList();
        } else {
            resultList = ads;
        }
        if (model != null && !resultList.isEmpty()) {
            resultList = resultList.stream().filter(e -> e.getModel().equals(model)).toList();
        }
        return resultList;
    }
}