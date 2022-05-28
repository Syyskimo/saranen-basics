package org.syyskimo.saranen.entities;

/**
 * Luokka (class) on kuvaus oliosta (object). Luokasta tehty instanssi on olio (object).
 *
 * Luokka voi periä (extends) toisen luokan. Luokka ei voi periä kuin yhden luokan. Joissain kielissä voi periä
 * useampia luokkia, tätä kutsutaan moniperinnäksi ja allekirjoittaneen mielestä se on hirveää :D
 *
 * Luokat voivat myös toteuttaa (implements) rajapintoja (interface). Rajapintoja voi toteuttaa niin paljon kuin
 * haluaa, eikä tässä ole samanlaista rajoitusta kuin perinnässä.
 *
 */
public class Woman extends Person implements Greeter {

    /**
     * Konstruktori (constructor) eli metodi jota kutsutaan kun uusi olio luodaan (new Woman("nimi", 25, 58.5) )
     * @param name Nimi
     * @param age Ikä
     * @param weight Paino (kilogrammoina)
     */
    public Woman(String name, int age,double weight) {
        // avainsana "super" viittaa luokkaan jonka tämä luokka perii
        // konstruktorissa voidaan kutsua yläluokan konstruktoria suoraan kutsulla super(parametrit....)
        // Tässä tapauksessa yläluokan konstruktoria kutsutaan suoraan annetuilla parametreilla, mutta
        // lisäksi asetetaan suoraan, että "female" -parametri on true
        super(name, age, true, weight);
    }

    /**
     * Abstraktin yläluokan (Person) abstrakti metodi tulee perivässä (ei-abstraktissa) luokassa
     */
    public void sayHey()
    {
        System.out.println("Heeeeey.... <3");
    }

    /**
     * Toteutettujen (implements) rajapintojen (interface) metodit tulee toteuttaa
     */
    @Override
    public void greet() {
        this.sayHey();

    }

    public String toString()
    {
        return "Olen nainen ja " + super.toString();
    }
}
