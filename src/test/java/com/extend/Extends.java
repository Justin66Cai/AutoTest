package com.extend;

class Animal{
    private String name;
    private int age;
//    public Animal() {
//
//    }

    public Animal(String name, int age) {
        name = name;
        age = age;
    }
    public void getAge() {
        System.out.println("年纪轻轻");
    }

    public void getName() {
        System.out.println("我是动物");
    }
}

class Dog extends Animal{
    private String name;
    private int age;
    public Dog(String myName, int myid) {
        super(myName, myid);
    }
    public void getAge(){
        System.out.println("旺旺");
    }
}

public class Extends {
    public static void main(String[] args) {
        Animal a = new Animal("don",12);
        a.getAge();
        a.getName();
        Dog d = new Dog("dog", 2);
        System.out.println("==================");
        d.getAge();
    }

}
