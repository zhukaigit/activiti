package org.crazyit.act.c7;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class ZipTest {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        
        FileInputStream fis = new FileInputStream(new File("bpmn/c7/datas.zip"));
        ZipInputStream zis = new ZipInputStream(fis);
        
        builder.addZipInputStream(zis);
        
        builder.deploy();
    }

}
