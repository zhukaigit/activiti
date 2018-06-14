package org.crazyit.act.c22;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class AssignmentTypeTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask arg0) {
        System.out.println("这个是assignment type监听器");
    }

}
