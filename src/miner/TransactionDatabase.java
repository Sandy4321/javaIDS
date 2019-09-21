/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author jfili
 */
public class TransactionDatabase {
    
    private ArrayList<Transaction> transactions;
    private HashMap<FrequentItem, Integer> frequentItemsFrequenciesMap  = new HashMap<>();
    
    public TransactionDatabase(ArrayList<Transaction> txns) {
        this.transactions = txns;
    }
    
    public void countFrequentItems() {
        for (Transaction transaction : transactions) {
            for (int j = 0; j < transaction.getItems().length; j++) {
                FrequentItem freqItem = transaction.getItems()[j];
                
                if (frequentItemsFrequenciesMap.containsKey(freqItem)) {
                    frequentItemsFrequenciesMap.put(freqItem, frequentItemsFrequenciesMap.get(freqItem) + 1);
                } else {
                    frequentItemsFrequenciesMap.put(freqItem, 1);
                }
            }
        }
        
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            for (int j = 0; j < transaction.getItems().length; j++) {
                FrequentItem freqItem = transaction.getItems()[j];
                
                freqItem.setFrequency(frequentItemsFrequenciesMap.get(freqItem));
            }
        } 
    }
 
    public void orderByFrequent() {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            
            Arrays.sort(transaction.getItems(), Collections.reverseOrder());
        } 
    }
    
    public void growFPTree() {
        FPNode fpTree = new FPNode();
        fpTree.freqItem = new FrequentItem("root", "-");
        
        
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            
            
            for (int j = 0; j < transaction.getItems().length; j++) {
                FrequentItem freqItem = transaction.getItems()[j];
                
                
            }
        } 
        
    }
    
    
    @Override
    public String toString() {
        String txt = "";
        
        for (Transaction txn : transactions) {
            txt += "\n" + txn.toString();
        }
        
        return txt;
    }

    /**
     * @return the transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the frequentItemsFrequenciesMap
     */
    public HashMap<FrequentItem, Integer> getFrequentItemsFrequenciesMap() {
        return frequentItemsFrequenciesMap;
    }

    /**
     * @param frequentItemsFrequenciesMap the frequentItemsFrequenciesMap to set
     */
    public void setFrequentItemsFrequenciesMap(HashMap<FrequentItem, Integer> frequentItemsFrequenciesMap) {
        this.frequentItemsFrequenciesMap = frequentItemsFrequenciesMap;
    }
    
    
    
    
}
