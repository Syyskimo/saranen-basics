package org.syyskimo.saranen.entities;

/**
 * Tämä luokka kuvaa juomaa. Juomalla on tiedot:
 * name : nimi, esimerkiksi "Karhu III"
 * vol : eli määrä litroina esim. 0.33
 * alcVol : eli alkoholin määrä esimerkiksi 4.7
 */
public class Drink {
    private String name;
    private double vol;
    private double alcVol;

    /**
     * Vakio kuvaamaan yhden ravintola-annoksen (käytetty pientä keskiolutta tähän arvioon) sisältämää raa'an
     * alkoholin määrää
     */
    public static final double ONESHOT = 0.01551;

    /**
     *
     * @param name Juoman nimi
     * @param vol tilavuus (litroissa)
     * @param alcVol alkoholiprosentti (prosenttiyksiköinä, esim. 5.5)
     */
    public Drink(String name, double vol, double alcVol)
    {
        this.name = name;
        this.vol = vol;
        this.alcVol = alcVol;
    }

    /**
     * toString -metodi on "maaginen" metodi, jota kutsutaan automaattisesti kaikilta olioilta silloin kun olio tulisi
     * kääntää (cast) merkkijonoksi (String). Tällainen tilanne on käytettäessä metodia joka haluaa String:in
     * System.out.println(olio) -> tällöin kutsutaan olion toString -metodia. Samoin String -käännös tehdään vaikkapa
     * silloin kun konkatenoidaan (liitetään) olio Stringiin, esim: "merkkijono" + olio
     *
     * @return Palauttaa jonkinlaisen merkkijonon kuvaamaan tätä oliota
     */
    public String toString()
    {
        return this.name + " " + String.format("%.2f", this.vol) + "l (" + String.format("%.1f", this.alcVol) + "%)";
    }

    /**
     * @return palauttaa raa'an alkoholin määrän tässä juomassa
     */
    public double getAlc()
    {
        return (this.vol * (this.alcVol / 100.0));
    }

    /**
     * @return Kertoo kuinka monta ravintola-annosta tämä juoma on (alkoholimäärältään)
     */
    public double getShotAmount()
    {
        return (this.getAlc() / Drink.ONESHOT);
    }

}
