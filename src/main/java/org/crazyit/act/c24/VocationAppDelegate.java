package org.crazyit.act.c24;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class VocationAppDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("填写请假单申请表");
        arg0.setVariable("days", 5);

    }
}
