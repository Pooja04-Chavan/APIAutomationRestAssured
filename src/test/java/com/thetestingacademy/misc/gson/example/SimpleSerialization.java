package com.thetestingacademy.misc.gson.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;


public class SimpleSerialization {

    @Test
    public void test1(){

        Employee employee=new Employee();
        employee.setFirstname("pooja");
        employee.setLastname("rathod");
        employee.setGender("Female");
        employee.setAge(26);
        employee.setSalary(1223.00);
        employee.setMarried(true);

        Gson gson=new Gson();
        String jsonObject=gson.toJson(employee);
        System.out.println(jsonObject);


        Gson gsonBuilder=new GsonBuilder().setPrettyPrinting().create();
        String employeeJsonUsinggsonBuilder=gsonBuilder.toJson(employee);
        System.out.println("-----Print Pretty string-----");
        System.out.println(employeeJsonUsinggsonBuilder);
    }
}
