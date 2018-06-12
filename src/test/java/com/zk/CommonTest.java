package com.zk;

import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.crazyit.act.ActivitiTools;
import org.junit.Test;

public class CommonTest {
  static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
  static RuntimeService runtimeService = processEngine.getRuntimeService();
  static TaskService taskService = processEngine.getTaskService();
  static RepositoryService repositoryService = processEngine.getRepositoryService();


  @Test
  public void testSuspendProcessDefinition() {
    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
        .processDefinitionKey("myProcess")
        .singleResult();
    //激活一个流程的定义
    repositoryService.activateProcessDefinitionById(processDefinition.getId());
    //挂起一个流程定义
//    repositoryService.suspendProcessDefinitionById(processDefinition.getId());
  }

  @Test
  public void testStartProcessInstanceByKey() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
    System.out.println(processInstance.getId());
    ActivitiTools.printCurrentTask(processInstance.getId());
  }

  @Test
  public void test1() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("multi_id");
    System.out.println(processInstance.getId());
    ActivitiTools.printCurrentTask(processInstance.getId());
  }

  @Test
  public void test2() {
    List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery()
        .processDefinitionKey("multi_id").list();
    for (ProcessInstance processInstance : processInstanceList) {
      List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId())
          .list();
      for (Task task : taskList) {
        System.out.println(String.format("pId = %s, taskName = %s, TaskDefinitionKey = %s",
            processInstance.getId(), task.getName(), task.getTaskDefinitionKey()));
        if ("usertask2".equals(task.getTaskDefinitionKey())) {
          taskService.complete(task.getId());
        }
      }
    }
  }


}
