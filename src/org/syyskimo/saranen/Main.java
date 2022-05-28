package org.syyskimo.saranen;

import org.syyskimo.saranen.entities.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Man manPerson = new Man("John Doe", 43, 95);
        Woman womanPerson = new Woman("Jane Doe", 25, 61);

        Drink karhu = new Drink("Karhu III", 0.33, 4.7);

        Drink westons = new Drink("Westons" , 0.5, 8.2);

        double drinkingHours = 4.5;

        // Listan voi luoda myös erilaisilla apumetodeilla, kuten tässä Arrays.asList -metodi
        List<Drink> drinkList = Arrays.asList(karhu, karhu, karhu, westons);

        // Listan voi loopata esimerkiksi for ([tyyppi] nimiYhdelle : Lista<tyyppi>)
        // jolloin mennään elementit läpi yksi kerrallaan. Huom! : Tälloin ei ole käytössä indeksiä (eli paikkaa listssa)
        for (Drink drink : drinkList) {
            manPerson.drink(drink);
            womanPerson.drink(drink);
        }

        // metodin greet parametriksi käy sekä Man että Woman, koska molemmat toteuttavat
        // Greeter -rajapinna. Pelkkä Person -luokka ei kelpaisi, koska se ei toteuta rajapintaa
        greet(manPerson);
        System.out.println(manPerson + " aloitin juomisen " + drinkingHours + " tuntia sitten ja puhallan alkometrista lukeman "
                + manPerson.getPoliceValue(drinkingHours));

        greet(womanPerson);
        System.out.println(womanPerson + " aloitin juomisen " + drinkingHours + " tuntia sitten ja puhallan alkometrista lukeman "
                + womanPerson.getPoliceValue(drinkingHours));


    }

    /**
     * Tässä metodi joka haluaa parametrikseen jonkun luokan joka on toteuttanut rajapinnan (interace) Greeter
     *
     * @param greeter joku luokka joka on toteuttanut rajapinnan (interace) Greeter
     */
    public static void greet(Greeter greeter)
    {
        greeter.greet();
    }
}
