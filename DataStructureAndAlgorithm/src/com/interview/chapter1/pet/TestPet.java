package com.interview.chapter1.pet;

public class TestPet {
    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Cat("white"));
        dogCatQueue.add(new Dog("black"));
        dogCatQueue.add(new Dog("yellow"));
        dogCatQueue.add(new Cat("red"));
        System.out.println(dogCatQueue.pollCat());
        System.out.println(dogCatQueue.pollDog());
        System.out.println(dogCatQueue.pollCat());
        System.out.println(dogCatQueue.pollDog());

//        System.out.println(dogCatQueue.pollAll());
//        System.out.println(dogCatQueue.pollAll());


    }
}
