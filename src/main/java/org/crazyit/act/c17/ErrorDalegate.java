package org.crazyit.act.c17;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ErrorDalegate implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("校验合同，发现不太正确，需要修改，抛出一个BpmnError错误");
    throw new BpmnError("30000");
  }
}
