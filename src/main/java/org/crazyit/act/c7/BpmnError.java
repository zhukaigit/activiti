package org.crazyit.act.c7;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

/**
 * builder.disableBpmnValidation();
 * 主要为了校验.bpmn文件语法是否正确
 */
public class BpmnError {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        builder.addClasspathResource("bpmn/c7/error/bpmn_error.bpmn");
        builder.disableBpmnValidation();
        builder.deploy();
    }

}
