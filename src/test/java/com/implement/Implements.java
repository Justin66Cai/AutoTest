package com.implement;

interface A {
    public void eat();
    public void sleep();
}

interface B {
    public void show();
}

class C implements A,B {
    public void eat(){
        System.out.println("吃");
    }

    @Override
    public void sleep() {
        System.out.println("睡");
    }

    @Override
    public void show() {
        System.out.println("show Time");
    }
}

public class Implements {



    public static void main(String[] args) {
        C c = new C();
        c.eat();
    }
}
