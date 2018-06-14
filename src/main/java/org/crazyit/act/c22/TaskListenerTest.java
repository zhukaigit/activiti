package org.crazyit.act.c22;

import java.util.HashMap;
import java.util.Map;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class TaskListenerTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        // 任务服务
        TaskService taskService = engine.getTaskService();
        Deployment dep = rs.createDeployment().addClasspathResource("bpmn/c22/task.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());
        
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();

        System.out.println("========== 即将调用【taskService.complete(task.getId())】 ==========");
        taskService.complete(task.getId());
        System.out.println("========== 完成调用【taskService.complete(task.getId())】 ==========");
    }

}
