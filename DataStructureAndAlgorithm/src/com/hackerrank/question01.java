package com.hackerrank;

public class question01 {
    public static void main(String[] args) {
        B b = new B();

        System.out.println(b instanceof B);
        System.out.println((b instanceof B) && (!(b instanceof A)));
        System.out.println((b instanceof B) && (!(b instanceof C)));
    }
}


class A {

}

class B extends A{

}

class C extends B{

}