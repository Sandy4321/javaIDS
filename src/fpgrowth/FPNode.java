/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpgrowth;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author jfili
 */
public class FPNode {
    
    private FrequentItem freqItem;
    private int frequency;
    
    private ArrayList<FPNode> children = new ArrayList<>();
    
    public FPNode() {
        this.frequency = 0;
    }
    
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
    
    /**
     * @return the freqItem
     */
    public FrequentItem getFreqItem() {
        return freqItem;
    }

    /**
     * @param freqItem the freqItem to set
     */
    public void setFreqItem(FrequentItem freqItem) {
        this.freqItem = freqItem;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the children
     */
    public ArrayList<FPNode> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<FPNode> children) {
        this.children = children;
    }
    
    public String printNode() {
        String txt = "(" + this.freqItem + ", " + this.frequency + ")" + "\n ";
        
        return txt;
    }
    
    @Override
    public String toString() {
        String txt = "";
        
        txt += this.printNode();
        for (FPNode fpNode : this.getChildren()) {
            txt += "->" + fpNode.printNode();
            for (FPNode child1 : fpNode.getChildren()) {
                txt += "-->" + child1.printNode();
                
                for (FPNode child2 : fpNode.getChildren()) {
                    txt += "--->" + child2.printNode();
                }
            }
        }
        
        return txt;
    }
    
    
}
