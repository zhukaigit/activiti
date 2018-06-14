package org.crazyit.act.c16;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class TerminalTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        TaskService taskService = engine.getTaskService();
        
        Deployment dep = rs.createDeployment().addClasspathResource("bpmn/c16/terminal.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());
        
        long exeCount = runService.createExecutionQuery().processInstanceId(pi.getId()).count();
        System.out.println("终止前执行流数量：" + exeCount);
        
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        for(Task task : tasks) {
            if(task.getName().equals("Task1")) {
                taskService.complete(task.getId());
            }
        }
        
        exeCount = runService.createExecutionQuery().processInstanceId(pi.getId()).count();
        System.out.println("终止后执行流数量：" + exeCount);
        
        ProcessInstance newPi = runService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult();
        System.out.println(newPi);
    }

}
