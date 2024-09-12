package com.example.qlm.wms;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class AdvertisementSystemImpl implements AdvertisementSystem {

    private final List<Advertisement> advertisements;
    private final Random random;

    public AdvertisementSystemImpl() {
        this.advertisements = new ArrayList<>();
        this.random = new Random();
    }

    @Override
    public void registerAdvertisement(Advertisement ad) {
        advertisements.add(ad);
    }

    @Override
    public void showNextAdvertisement(int dayIndex) {
        // Az összes reklám súlyának összege
        double totalWeight = advertisements.stream()
                .mapToDouble(Advertisement::getWeight)
                .sum();

        // Véletlenszerűen kiválasztjuk, melyik reklám jelenik meg a súlyok alapján. Ha a véletlenszerűen választott érték kisebb, mint a reklám valószínűsége, akkor megjelenítjük
        for (Advertisement ad : advertisements) {
            double probability = ad.getWeight() / totalWeight;

            if (random.nextDouble() < probability) {
                int todayAppearances = ad.getAllAppearences().getOrDefault(dayIndex, 0);

                if (todayAppearances < ad.getMaxAppearance()) {
                    ad.getAllAppearences().put(dayIndex, todayAppearances + 1);
                    ad.showAdvertisement();  // Meghívjuk a megjelenítési metódust
                } else {
                    System.out.println("Elérte a maximális megjelenések számát a(z) " + dayIndex + " napon.");
                }
            }
        }
    }

    @Override
    public List<Advertisement> getAdvertisementList() {
        return advertisements;
    }
}

