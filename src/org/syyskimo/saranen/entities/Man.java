package org.syyskimo.saranen.entities;

public class Man extends Person implements Greeter {
    /**
     *
     * @param name Nimi
     * @param age Ikä
     * @param weight Paino (kiloissa)
     */
    public Man(String name, int age, double weight)
    {
        super(name, age, false, weight);
    }

    @Override
    public void sayHey() {
        System.out.println("Moroooo!");
    }

    @Override
    public void greet() {
        this.sayHey();

    }

    public String toString()
    {
        return "Olen mies ja " + super.toString();
    }

}
