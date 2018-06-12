package org.crazyit.act;

import org.activiti.engine.ProcessEngineConfiguration;

public class CleanData {

    public static void main(String[] args) {
        cleanData();
    }

    public static void cleanData() {
        ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        config.setDatabaseSchemaUpdate("drop-create");
        config.buildProcessEngine();
    }

}
