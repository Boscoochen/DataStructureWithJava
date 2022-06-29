package com.interview.pet;

public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Cat extends Pet{
    private String name;
    public Cat(String name) {
        super("cat");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Dog extends Pet{
    private String name;

    public Dog(String name) {
        super("dog");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}