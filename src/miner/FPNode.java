/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author jfili
 */
public class FPNode {
    
    public FrequentItem freqItem;
    public int frequency;
    
    public ArrayList<FPNode> children;
    
    
    public Optional<FPNode> getChild(FrequentItem freqItem) {
        for (int i = 0; i < children.size(); i++) {
            FPNode child = children.get(i);
            if (child.freqItem.equals(freqItem)) {
                return Optional.of(child);
            }
        }
        return Optional.empty();
    }
    
    public void addToTree() {
        
    }
    
    public void setChild(FrequentItem freqItem) {
        
    }
    
}
