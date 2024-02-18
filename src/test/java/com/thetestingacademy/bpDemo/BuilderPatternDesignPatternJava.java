package com.thetestingacademy.bpDemo;

public class BuilderPatternDesignPatternJava {

    // Change return type of each method as Class type
    // "this" always points to current/calling object. Returning the same to
    // have same reference

    public BuilderPatternDesignPatternJava stage1()
    {
        System.out.println("stage1");
        return this;
    }
    public BuilderPatternDesignPatternJava stage2(String str)
    {
        System.out.println("stage2 string is "+str);
        return this;
    }
    public BuilderPatternDesignPatternJava stage3()
    {
        System.out.println("stage3");
        return this;
    }

    public static void main(String[] args) {

        BuilderPatternDesignPatternJava bp= new BuilderPatternDesignPatternJava();
        bp.stage1().stage2("test").stage3();

    }
}
