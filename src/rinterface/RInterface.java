/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rinterface;

import java.util.ArrayList;
import javaids.ClassAssociationRule;
import javaids.DataFrame;
import javaids.loaders.RuleLoader;

/**
 *
 * @author jfili
 */
public class RInterface {
    
    private DataFrame dataframe;
    private ArrayList<ClassAssociationRule> rules;
    
    public RInterface() {
        
    }
    
    public int loadRules(String[][] ruleMatrix) {
        
       
        RuleLoader ruleLoader = new RuleLoader();
        ruleLoader.loadRules(ruleMatrix);
        
        return 1;
    }
    
    public String printSomething() {
        return "ahoj";
    }
    
    
}
