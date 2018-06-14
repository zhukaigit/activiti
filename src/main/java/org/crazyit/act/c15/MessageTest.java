package org.crazyit.act.c15;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.crazyit.act.ActivitiTools;

public class MessageTest {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        
        Deployment dep = rs.createDeployment().addClasspathResource("bpmn/c15/message.bpmn").deploy();
        
        ProcessInstance pi = runService.startProcessInstanceByMessage("msgName");
        ActivitiTools.printCurrentTask(pi.getId());
        System.out.println(pi.getId());
    }

}
