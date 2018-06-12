package org.crazyit.act.c6;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestListPage {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = engine.getIdentityService();
        
        List<Group> groups = is.createGroupQuery().listPage(1, 5);
        for(Group g : groups) {
            System.out.println(g.getId() + "---" + g.getName() + "---" + g.getType());
        }
    }

}
