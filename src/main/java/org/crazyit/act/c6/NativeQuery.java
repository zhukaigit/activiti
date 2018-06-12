package org.crazyit.act.c6;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class NativeQuery {

    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService is = engine.getIdentityService();

        List<Group> groups = is.createNativeGroupQuery()
                .sql("SELECT * FROM ACT_ID_GROUP where NAME_ = #{name}")
                .parameter("name", "Group_2").list();
        for (Group g : groups) {
            System.out.println(g.getId());
        }
    }

}
