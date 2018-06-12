package org.crazyit.act.c8;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

//主要是使用【repositorySerice.suspendProcessDefinitionByKey】来暂停一个流程
public class ActiveTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService repositorySerice = engine.getRepositoryService();
        
        DeploymentBuilder builder = repositorySerice.createDeployment();
        builder.addClasspathResource("bpmn/c8/test3.bpmn");
        Deployment dep = builder.deploy();

        ProcessDefinition def = repositorySerice.createProcessDefinitionQuery()
                .deploymentId(dep.getId()).singleResult();

        System.out.println("id: " + def.getId());
        repositorySerice.suspendProcessDefinitionByKey(def.getKey());
        // 将会抛出异常，因为流程定义被中止了
        RuntimeService runService = engine.getRuntimeService();
        runService.startProcessInstanceByKey(def.getKey());
    }

}
