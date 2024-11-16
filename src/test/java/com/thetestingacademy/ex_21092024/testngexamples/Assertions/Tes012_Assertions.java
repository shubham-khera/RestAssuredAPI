package com.thetestingacademy.ex_21092024.testngexamples.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tes012_Assertions {
    @Test
    public void hardAssertExample(){
        Assert.assertTrue(false);
        System.out.println("This line will not be executed");
    }

    @Test
    public void softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed.");
        softAssert.assertAll();
    }
}
