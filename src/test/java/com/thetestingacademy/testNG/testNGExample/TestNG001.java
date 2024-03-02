package com.thetestingacademy.testNG.testNGExample;

import org.testng.annotations.*;

public class TestNG001 {
    @BeforeSuite
    void demo1()
    {
        System.out.println("Before suites");
    }

    @BeforeClass
    void demo2()
    {
        System.out.println("Before class");
    }
    @BeforeTest
    void demo3(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }
    @Test
    void demo5(){
        System.out.println("Before Test");
    }
    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }
    @AfterTest
    void demo7(){
        System.out.println("After Test");
    }
    @AfterClass
    void demo8(){
        System.out.println("After Class");
    }
    @AfterSuite
    void demo9(){
        System.out.println("After suites");
    }

}
