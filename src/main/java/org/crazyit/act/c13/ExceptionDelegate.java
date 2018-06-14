package org.crazyit.act.c13;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ExceptionDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        System.out.println("这是异常处理类");
        throw new RuntimeException("always exception");
    }
}
