/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

/**
 *
 * @author jfili
 */
public class FrequentItem implements Comparable<FrequentItem> {

    private String label;
    private String value;
    private int frequency;
    
    public FrequentItem(String label, String value) {
        this.label = label;
        this.value = value;
        this.frequency = 0;
    }
    
    @Override
    public String toString() {
        return "(" + this.label + ":=:" + this.value + ", " + this.frequency + ")";
    }
    
    @Override
    public int hashCode() {
        int result = (this.label + this.value).hashCode();
        
        return result;
    } 
    
    @Override
    public boolean equals(Object other) {
        
        return this.hashCode() == other.hashCode();
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
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
    

    @Override
    public int compareTo(FrequentItem other) {
        if (this.getFrequency() > other.getFrequency()) {
            return 1;
        }
        else if (this.getFrequency() < other.getFrequency()) {
            return -1;
        }
        else {
            return 0;
        }

    }

    
    
    
    
    
}
