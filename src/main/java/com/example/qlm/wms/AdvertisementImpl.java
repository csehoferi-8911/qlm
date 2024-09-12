package com.example.qlm.wms;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;

@Slf4j
public class AdvertisementImpl implements Advertisement {

    private String name;
    private final int maxAppearance;
    private final double weight;
    private final Hashtable<Integer, Integer> appearances;

    public AdvertisementImpl(int maxAppearance, double weight, String name) {
        this.maxAppearance = maxAppearance;
        this.weight = weight;
        this.appearances = new Hashtable<>();
        this.name = name;
    }

    @Override
    public int getMaxAppearance() {
        return maxAppearance;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int lastAppearence(int dayIndex, int numberOfDays) {
        int totalAppearances = 0;

        // Végigmegyünk az utolsó numberOfDays nap megjelenésein
        for (int day = dayIndex; day > dayIndex - numberOfDays && day >= 0; day--) {
            totalAppearances += appearances.getOrDefault(day, 0);
        }

        return totalAppearances;
    }

    @Override
    public void showAdvertisement() {
        log.info("Megjelenített reklám: {}", name);
    }

    @Override
    public Hashtable<Integer, Integer> getAllAppearences() {
        return appearances;
    }
}
