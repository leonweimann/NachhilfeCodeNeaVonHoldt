package oop;

public class Person {
    private String name;
    private int alter;

    public Person(String name, int alter) {
        this.name = name; // this.name = name in dieser Klasse
        this.alter = alter;
    }

    public void macheEtwas() {
        name += "!";
    }

    public void macheEtwasAnderes() {
        System.out.println(name);
        System.out.println(alter);
    }
}
