package com.thetestingacademy;

public class BuilderPatternDesignPatternJava {

    public BuilderPatternDesignPatternJava floor1() {
        System.out.println("Floor 1 is Done");
        return this;
    }

    public BuilderPatternDesignPatternJava floor2() {
        System.out.println("Floor 2 is Done");
        return this;
    }

    public BuilderPatternDesignPatternJava floor3() {
        System.out.println("Floor 3 is Done");
        return this;
    }

    public static void main(String[] args) {
        BuilderPatternDesignPatternJava bp = new BuilderPatternDesignPatternJava();
        bp.floor1().floor2().floor3();
    }
}
