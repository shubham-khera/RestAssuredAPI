package com.thetestingacademy;

public class NoDesignPattern {
    public void step1() {
        System.out.println("Step 1");

    }

    public void step2() {
        System.out.println("Step 2");

    }

    public void step3(String Param1) {
        System.out.println("Step 3");
        System.out.println(Param1);

    }

    public static void main(String[] args) {
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Testing");
    }
}
