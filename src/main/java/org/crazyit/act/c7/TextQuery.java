package org.crazyit.act.c7;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class TextQuery {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        builder.addClasspathResource("my_text.txt");
        Deployment dep = builder.deploy();
        // 数据查询
        InputStream is = rs.getResourceAsStream(dep.getId(), "my_text.txt");
        int count = is.available();
        byte[] contents = new byte[count];
        is.read(contents);
        String result = new String(contents);
        //输入结果
        System.out.println(result);

    }

}
