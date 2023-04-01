package com.example.workflow;

import jdk.jfr.Name;
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
public class CreateDraft implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String productName = "Gold";
        Random rand = new Random();
        int productId = rand.nextInt(1000);
        VariableMap variables = Variables.createVariables();
        variables.put("productId", productId);
        variables.put("productName", productName);

        delegateExecution.setVariables(variables);
        Logger.getLogger("CreateDraft")
                .log(Level.INFO, "New Product Draft {0} with Name {1} is created..!", new Object[]{productId, productName});
    }
}
