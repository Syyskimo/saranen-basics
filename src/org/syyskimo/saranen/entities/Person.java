package org.syyskimo.saranen.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Tämä luokka kuvaa henkilöä. Luokka on abstrakti (abstract), joka tarkoittaa ettei tästä luokasta voi tehdä ilmentymiä
 * (eli olioita) vaan tämä luokka tulee periä (extends) jollain ei-abstraktilla luokalla, jotta voidaan tehdä ilmentymiä.
 *
 * Henkilöllö on tiettyjä ominaisuuksia (properties, eli luokan muuttujat):
 * name, eli nimi
 * age, eli ikä (toki koska muuttuva suure, niin iän tallentaminen on melko hölmöä koska se vanhenee vuodessa tai alle)
 * weight, paino kiloina
 * female, boolean eli tosi/epätosi (true/false) -tyyppinen tieto joka kertoo onko henkilö nainen vai ei (eli mies)
 * uuid, yksilöllinen tunniste
 *
 * Lisäksi luokilla on metodeja. Nämä metodit ovat käytännössä luokan (tai oikeastaan olion, jos eivät ole staattisia)
 * funktioita.
 *
 */
abstract public class Person {
    private String name;
    private int age;
    private double weight;
    private boolean female;

    private UUID uuid;

    private List<Drink> drinks;

    /**
     * Tämä on luokan vakio. Vakio tarkoittaa arvoa jota ei voi muuttaa. Ja avainsana "static" taas määrittelee, että
     * kyseessä luokan - ei olion - tieto. Tämä tarkoittaa, että sitä käyttääkseen ei tarvitse olla oliota luotuna. Ja
     * jos kyseessä olisi muuttuja (eli ei olisi final -vakio), niin muuttujia olisi vain yksi käytössä, sen sijaan että
     * jokaisella luodulla oliolla olisi omansa. Vrt. propertyt (eli perusmuuttajat oliossa): propertyt ovat vain käytössä
     * kun olio on luotu ja ne on kiinnitetty juuri siihen olioon.
     *
     * Tämä kyseinen luokkavakio kertoo laskuissa suhdeluvun veden määrässä naisilla (eli naislla 55% massasta on vettä)
     */
    public static final double WATER_RATIO_FEMALE = 0.55;
    /**
     * Tämä kyseinen luokkavakio kertoo laskuissa suhdeluvun veden määrässä miehillä (eli miehillä 68% massasta on vettä)
     */
    public static final double WATER_RATIO_MALE = 0.68;
    /**
     * Tämä vakio kertoo alkoholin "poltto" nopeuden. Eli monta promillea tunnissa poistuu alkoholia kehosta.
     * Esimerkiksi: 1 promillen alkoholin kokonaan poistuminen kehosta vie vähän alta kuusi tuntia
     */
    public static final double ALC_DECAY_PER_HOUR = 0.17;

    /**
     * Luokan konstruktori. Tämä tarkoittaa erikoisfunktiota (eli metodia) jota kutsutaan silloin kun luodaan uusi
     * uusi (new) instanssi (olio) luokasta.
     *
     * @param name Nimi
     * @param age Ikä
     * @param female onko kyseinen henkilö nainen. Jos ei, niin oletetaan että mies
     * @param weight paino (kilogrammoina)
     */
    protected Person(String name, int age, boolean female, double weight) {
        this.name = name;
        this.age = age;
        this.female = female;
        this.weight = weight;
        this.drinks = new ArrayList<>();
        this.uuid = UUID.randomUUID();
    }

    /**
     * @return palauttaa henkilön yksilöllisen tunnisteen merkkijonona (String)
     */
    public String getUUID() {
        return this.uuid.toString();
    }

    /**
     * @return kertoo kuinka monta Drinkkiä on juotu
     */
    public int howManyIDrank() {
        return this.drinks.size();
    }
    /**
     * @return Palauttaa juotujen ravintola-annosten määrän (jossa 1 ravintola-annos on 1 pieni keskiolut)
     */
    public double getShotAmount() {
        double shotAmount = 0.0;

        for(Drink drink: this.drinks) {
            shotAmount += drink.getShotAmount();
        }
        return shotAmount;

    }

    /**
     *
     * @return Laskee yhteen ja palauttaa kaikkien juotujen juomien sisältämän raa'an alkoholin määrän
     */
    public double getConsumedAlc() {
        double alcAmount = 0.0;

        for(Drink drink: this.drinks) {
            alcAmount += drink.getAlc();
        }
        return alcAmount;
    }

    /**
     *
     * @param hours montako tuntia sitten juominen on aloitettu
     * @return promillemäärä
     */
    public double getPromile(double hours) {
        return (this.getConsumedAlc() / this.getWaterAmount() * 1000.0) - (ALC_DECAY_PER_HOUR * hours);

    }

    /**
     * Leikkisä metodi joka palauttaa promillen hieman mukavammin tulkittuna tekstuaalisesti
     *
     * @param hours montako tuntia sitten juominen on aloitettu
     * @return Promillemäärä tekstuaalisena (pyöristetty kahteen desimaaliin ja laitettu "%." perään)
     */
    public String getPoliceValue(double hours) {
        return  String.format("%.2f", this.getPromile(hours)) + "%.";
    }

    /**
     * "Juo" juoman, eli käytännössä lisää olion sisäiseen listaan
     *
     * @param drink Juotava juoma
     */
    public void drink(Drink drink) {
        this.drinks.add(drink);
    }

    public String toString()
    {
        String ret =  "nimeni on " + this.name + " ja ikäni " + this.age;
        return ret;
    }

    /**
     * @return Palauttaa veden määrän kehossä (kiloina/litroina, sama asia)
     */
    public double getWaterAmount()
    {
        return this.weight * this.getWaterRatio();
    }

    /**
     * @return Palauttaa veden suhdeluvun (eli montako prosenttia henkilön massasta on vettä)
     */
    public double getWaterRatio()
    {
        return (this.female ? WATER_RATIO_FEMALE : WATER_RATIO_MALE);

    }

    /**
     * Tämä on abstrakti metodi. Se tarkoittaa, ettei metodilla ole varsinaista sisältä määriteltynä. Kun joku muu
     * luokka perii tämän luokan, tulee tämä metodi toteuttaa.
     */
    public abstract void sayHey();


}
