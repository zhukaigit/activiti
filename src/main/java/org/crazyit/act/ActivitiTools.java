package org.crazyit.act;

import java.util.List;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class ActivitiTools {

  static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
  static RuntimeService runtimeService = processEngine.getRuntimeService();
  static TaskService taskService = processEngine.getTaskService();
  static RepositoryService repositoryService = processEngine.getRepositoryService();

  public static void printCurrentTask(String processInstanceId) {
    List<Task> list = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
    System.out.println("当前的节点：" + list);
  }

  public void t() {
    IdentityService identityService = processEngine.getIdentityService();
    taskService.createTaskQuery().processInstanceId("").singleResult().getOwner();

  }


}
