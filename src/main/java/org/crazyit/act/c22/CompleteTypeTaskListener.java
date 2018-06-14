package org.crazyit.act.c22;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class CompleteTypeTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask arg0) {
        System.out.println("这个是complete type监听器");
    }

}
