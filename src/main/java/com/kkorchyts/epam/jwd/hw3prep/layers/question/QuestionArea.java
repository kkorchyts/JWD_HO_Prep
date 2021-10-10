package com.kkorchyts.epam.jwd.hw3prep.layers.question;

public class QuestionArea {
    static class Animal {
        private Animal() {}

    }
    static class Cat extends Animal {
        public void print() {}

        public static void print(int i, int j) {}
        public Cat() {}
        protected Cat(int a) {}


    }
    static class MainCoon extends Cat {
        private MainCoon() {}
        protected MainCoon(int a) {}
        public MainCoon(int a, int b) {}

/*        public void print(char i) {
            System.out.println("char - " + i);
        }*/

        public void print(double i) {
            System.out.println("int - " + i);
        }
    }


    public static void main(String[] args) {
        Animal animal = new MainCoon();
        Cat cat = new Cat();
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Cat);
        System.out.println(animal instanceof MainCoon);

        System.out.println(cat instanceof Animal);
        System.out.println(cat instanceof Cat);
        System.out.println(cat instanceof MainCoon);

        System.out.println(null instanceof MainCoon);

        MainCoon mc = (MainCoon)animal;
        mc.print(1);
        mc.print('1');


    }
}
