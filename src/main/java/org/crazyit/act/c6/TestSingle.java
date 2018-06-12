package org.crazyit.act.c6;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestSingle {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = engine.getIdentityService();
        
        Group g = is.createGroupQuery().groupName("Group_0").singleResult();
        System.out.println(g.getId());
    }

}
