package org.syyskimo.saranen.entities;

/**
 * Interface, eli rajapinta, ei ole luokka vaan vain kuvaus toiminnoista. Jos joku luokka toteuttaa rajapinnan
 * (implements [interface]) se tarkoittaa, että luokka toteuttaa rajapinnan (interface) esittelemät metodit.
 *
 * Tämä tarkoittaa, että vaikka sinänsä interface:sta ei voi tehdä ilmentymää (kuten luokka => olio)
 */
public interface Greeter {

    /**
     * rajapinnan metodi joka pitää toteuttaa, sikäli kun rajapinta (interface) halutaan toteuttaa
     */
    void greet();
}