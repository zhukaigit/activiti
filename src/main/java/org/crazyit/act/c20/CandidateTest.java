package org.crazyit.act.c20;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class CandidateTest {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        // 运行时服务
        RuntimeService runService = engine.getRuntimeService();
        IdentityService is = engine.getIdentityService();
        // 任务服务
        TaskService taskService = engine.getTaskService();

        // 创建用户组
        Group bossG = is.newGroup("boss");
        bossG.setName("boss");

        Group mangG = is.newGroup("management");
        mangG.setName("management");
        
        is.saveGroup(bossG);
        is.saveGroup(mangG);
        
        User user = is.newUser("angus");
        user.setFirstName("Angus");
        is.saveUser(user);

        Deployment dep = rs.createDeployment()
                .addClasspathResource("bpmn/c20/candidate.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery()
                .deploymentId(dep.getId()).singleResult();
        ProcessInstance pi = runService.startProcessInstanceById(pd.getId());
        
        // 查询各个用户下面有权限看到的任务
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("boss").list();
        System.out.println(tasks.size());
        System.out.println("boss用户组，可以认领的任务：" + tasks.get(0).getName());
        
        taskService.createTaskQuery().taskCandidateGroup("management").list();
        System.out.println("management用户组，可以认领的任务：" + tasks.size() + "---" + tasks.get(0).getName());
        
        taskService.createTaskQuery().taskCandidateUser("angus").list();
        System.out.println("angus用户，可以认领的任务：" + tasks.size() + "---" + tasks.get(0).getName());
    }
}
