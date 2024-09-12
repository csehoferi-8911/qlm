package com.example.qlm.wms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    @GetMapping()
    public void getAdvertisement() {
        AdvertisementSystem system = new AdvertisementSystemImpl();

        // Reklámok regisztrálása
        Advertisement ad1 = new AdvertisementImpl(5, 0.1, "ad1"); // Max 5-ször jelenhet meg, súlya 0.1
        Advertisement ad2 = new AdvertisementImpl(3, 0.2, "ad2"); // Max 3-szor, súlya 0.2
        Advertisement ad3 = new AdvertisementImpl(7, 0.1, "ad3"); // Max 7-szer, súlya 0.5

        system.registerAdvertisement(ad1);
        system.registerAdvertisement(ad2);
        system.registerAdvertisement(ad3);

        // Napi megjelenítések szimulálása
        for (int day = 0; day < 10; day++) {
            log.info("Nap: {}", day);
            system.showNextAdvertisement(day); // Minden nap megpróbálunk egy reklámot megjeleníteni
        }

        // Ellenőrizzük, hogy hányszor jelent meg az adott reklám az utolsó 7 napban
        log.info("Ad1 megjelenések száma az utolsó 7 napban: {}", ad1.lastAppearence(10, 7));
        log.info("Ad2 megjelenések száma az utolsó 7 napban: {}", ad2.lastAppearence(10, 7));
        log.info("Ad3 megjelenések száma az utolsó 7 napban: {}", ad3.lastAppearence(10, 7));
    }
}
