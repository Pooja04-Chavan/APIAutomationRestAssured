package com.thetestingacademy.testNG.listenerDemo;

import org.testng.IExecutionListener;
import org.testng.ISuiteListener;

public class CustomListener implements IExecutionListener, ISuiteListener {
@Override
    public void onExecutionFinish()
    {
        long endTime= System.currentTimeMillis();
        System.out.println("***** ***** Finished Execution at"+endTime+"***** ******");

        // Send email to the QA lead
        // Write Java code to write the Email to QA lead
        //




    }
}
