package org.crazyit.act.c22;

import java.util.Map;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.impl.el.FixedValue;
import org.activiti.engine.task.Task;

public class CreateTypeTaskListener implements TaskListener {

    private FixedValue userName;

    public void setUserName(FixedValue userName) {
        this.userName = userName;
    }


    @Override
    public void notify(DelegateTask arg) {
        System.out.println("这是create type自定义任务监听器, userName =" + userName.getExpressionText());
    }


}
