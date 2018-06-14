package org.crazyit.act.c15;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * time开始事件
 * 注意：需要在activiti.cfg.xml文件中配置<property name="asyncExecutorActivate" value="true"/>
 */
public class TimerTest {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        
        Deployment dep = rs.createDeployment().addClasspathResource("bpmn/c15/timer.bpmn").deploy();
        
        long dataCount = runService.createProcessInstanceQuery().count();
        System.out.println("sleep前流程实例数量：" + dataCount);

//        for(int i = 0; i < 10; i++) {
//            Thread.sleep(3000);
//            dataCount = runService.createProcessInstanceQuery().count();
//            System.out.println("sleep后流程实例数量：" + dataCount);
//        }
        Thread.sleep(20000);
    }

}
