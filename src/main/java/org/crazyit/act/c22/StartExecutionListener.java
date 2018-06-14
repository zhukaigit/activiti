package org.crazyit.act.c22;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class StartExecutionListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) {
    System.out.println("这个是StartExecutionListener");
  }
}
