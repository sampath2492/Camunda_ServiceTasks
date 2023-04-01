package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import javax.inject.Named;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
public class ApproveDraft implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int productId = (Integer) delegateExecution.getVariable("productId");
        String productName = (String) delegateExecution.getVariable("productName");
        Logger.getLogger("ApproveDraft")
                .log(Level.INFO, "New Product Draft {0} with Name {1} is Approved..!", new Object[]{productId, productName});
    }
}
