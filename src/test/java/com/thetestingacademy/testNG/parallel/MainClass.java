package com.thetestingacademy.testNG.parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {

    @BeforeMethod
    public void BeforeMethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Before Test - method. thread id is: "+ id +getClass().getSimpleName());
    }

    @Test
    public void testMethod1()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method One. Thread id is:"+ id+getClass().getSimpleName());
    }

    @Test
    public void testMethod2()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method Two. Thread id is:"+ id+getClass().getSimpleName());
    }

    @Test
    public void testMethod3()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method Three. Thread id is:"+ id+getClass().getSimpleName());
    }

    @Test
    public void testMethod4()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method four. Thread id is:"+ id+getClass().getSimpleName());
    }

    @Test
    public void testMethod5()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method five. Thread id is:"+ id+getClass().getSimpleName());
    }

    @Test
    public void testMethod6()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Simple method six. Thread id is:"+ id+getClass().getSimpleName());
    }

    @AfterMethod
    public void afterMethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("After test method. Thread id is:"+ id+getClass().getSimpleName());
    }
}
