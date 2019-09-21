/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaids;

import java.util.HashMap;

/**
 *
 * @author jfili
 */
public class ClassAssociationRule implements Comparable<ClassAssociationRule> {

    private HashMap<String, String> antecedent;
    private String consequent;
    
    private double confidence;
    private double support;
    private double f1;
    
    public ClassAssociationRule(HashMap<String, String> conditions, 
                                String consequent) {
        this.antecedent = conditions;
        this.consequent = consequent;
    }
    
    @Override
    public String toString() {
        String s = "CAR {";
        
        for (String condition : antecedent.keySet()) {
            String value = antecedent.get(condition);
            s +=  condition + "=" + value + ", ";  
        }
                
        s += "} --->";
        
        s += " class=" + consequent;
                
              
        return s;
    }
    
    public boolean[] calculateRuleOverlap(ClassAssociationRule rule, DataFrame dataFrame) {
        boolean[] coverSelf = dataFrame.calculateRuleCoverMask(this);
        boolean[] coverOther = dataFrame.calculateRuleCoverMask(rule);
        
        boolean[] overlap = new boolean[coverSelf.length];
        
        for (int i = 0; i < coverSelf.length; i++) {
            overlap[i] = coverSelf[i] && coverOther[i];
        }
        
        return overlap;
    }

    /**
     * @return the antecedent
     */
    public HashMap<String, String> getAntecedent() {
        return antecedent;
    }

    /**
     * @return the consequent
     */
    public String getConsequent() {
        return consequent;
    }

    /**
     * @return the confidence
     */
    public double getConfidence() {
        return confidence;
    }

    /**
     * @param confidence the confidence to set
     */
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    /**
     * @return the support
     */
    public double getSupport() {
        return support;
    }

    /**
     * @param support the support to set
     */
    public void setSupport(double support) {
        this.support = support;
    }

    /**
     * @return the f1
     */
    public double getF1() {
        return f1;
    }

    /**
     * @param f1 the f1 to set
     */
    public void setF1(double f1) {
        this.f1 = f1;
    }

    @Override
    public int compareTo(ClassAssociationRule other) {
        if (this.getF1() > other.getF1()) {
            return 1;
        }
        else if (this.getF1() < other.getF1()) {
            return -1;
        }
        else if (this.getF1() == other.getF1()) {
            return 0;
        }
        else {
            return 0;
        }
    }

    
}
