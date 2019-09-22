/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import fpgrowth.FrequentItem;
import fpgrowth.Transaction;
import fpgrowth.TransactionDatabase;

/**
 *
 * @author jfili
 */
public class DataFrame {
    
    private String[] header;
    private String[][] transactions;
    private int transactionCount;
    private int variableCount;
    
    public DataFrame() {
    }
    
    public void readFromCSV(String pathToCSV){
        String row;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
            LinkedList<String[]> tempTransactions = new LinkedList<>();
            
            boolean headerRead = false; 
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                
                if (!headerRead) {
                    this.setHeader(data);
                    headerRead = true;
                    continue;
                }
                
                tempTransactions.add(data);
                this.transactionCount = tempTransactions.size();
                this.variableCount = header.length;
                
                this.transactions = new String[transactionCount][header.length];
                
                int idxCounter = 0;
                for (String[] txn : tempTransactions) {
                    this.transactions[idxCounter] = txn;
                    
                    idxCounter++;
                }
                
                
            }
            
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
                
          
    }
    
    public boolean[] calculateAntecedentCoverMask(ClassAssociationRule rule) {
        boolean[] mask = new boolean[this.transactionCount];
        
        for (int transactionIdx = 0; transactionIdx < this.transactionCount; transactionIdx++) {
            boolean instanceSatisfiesTransaction = true;
            
            for (String attribute : rule.getAntecedent().keySet()) {
                String value = rule.getAntecedent().get(attribute);
                int attributeIdx = Arrays.asList(header).indexOf(attribute);
                
                String currentVal = this.transactions[transactionIdx][attributeIdx];
                
                instanceSatisfiesTransaction &= value.equals(currentVal);
               
            }
            mask[transactionIdx] = instanceSatisfiesTransaction;
            System.out.println(instanceSatisfiesTransaction);
            System.out.println("");
        }
        
        
        return mask;
    }
    
    public boolean[] calculateRuleCoverMask(ClassAssociationRule rule) {
        return calculateAntecedentCoverMask(rule);
    }
    
    public TransactionDatabase convertToTransactionDatabase() {
        ArrayList<Transaction> transactionArrayList = new ArrayList<Transaction>();
        
        for (int rowIdx = 0; rowIdx < this.transactionCount; rowIdx++) {
            FrequentItem[] currentTransaction = new FrequentItem[this.variableCount];
            
            for (int colIdx = 0; colIdx < this.variableCount; colIdx++) {
                String currentColumnName = this.header[colIdx];
                String currentValue = this.transactions[rowIdx][colIdx];
                
                currentTransaction[colIdx] = new FrequentItem(currentColumnName, currentValue);
            }
            
            transactionArrayList.add(new Transaction(currentTransaction));
        }
        
        return new TransactionDatabase(transactionArrayList);
   }

    /**
     * @return the header
     */
    public String[] getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String[] header) {
        this.header = header;
    }

    /**
     * @return the transactions
     */
    public String[][] getTransactions() {
        return transactions;
    }

    
}
