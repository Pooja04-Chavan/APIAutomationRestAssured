package com.thetestingacademy.testNG.listenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class TC001 {

    @Test(groups = "sanity")
    public void test1()
    {
        System.out.println("test 1");
        Assert.assertTrue(true);
    }

    @Test(groups = "sanity")
    public void test2()
    {
        System.out.println("test 2");
        Assert.assertTrue(true);
    }

@AfterSuite
    public void emailToQALead()
    {
        // send the mail

    }

}
