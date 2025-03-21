package com.startjava.lesson_2_3.person;

public class Person {
    
    String gender = "male";
    String name = "John";
    int height = 184;
    int weight = 100;
    int age = 77;

    void move() {
        System.out.println("Иду");
    }

    void sit() {
        System.out.println("Сижу");
    }

    void run() {
        System.out.println("Бегу");
    }

    void speak() {
        System.out.println("Говорю");
    }

    void learnJava() {
        System.out.println("Изучаю Java");
    }
}