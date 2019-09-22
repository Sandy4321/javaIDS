/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpgrowth;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author jfili
 */
public class Transaction {
    
    private FrequentItem[] items;
    private int frequentItemSize;
    
    public Transaction(FrequentItem[] items) {
        this.items = items;
        this.frequentItemSize = items.length;
    }
    
    public Transaction(int frequentItemSize) {
        this.frequentItemSize = frequentItemSize;
        items = new FrequentItem[this.frequentItemSize];
    }

    /**
     * @return the items
     */
    public FrequentItem[] getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(FrequentItem[] items) {
        this.items = items;
    }

    /**
     * @return the frequentItemSize
     */
    public int getFrequentItemSize() {
        return frequentItemSize;
    }

    /**
     * @param frequentItemSize the frequentItemSize to set
     */
    public void setFrequentItemSize(int frequentItemSize) {
        this.frequentItemSize = frequentItemSize;
    }
    
    @Override
    public String toString() {
        String txt = "";
        
        for (FrequentItem item : items) {
            txt += ", " + item.toString();
        }
        
        return txt;
    }
    
}
