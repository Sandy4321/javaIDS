/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import fpgrowth.FPGrowth;
import fpgrowth.FrequentItem;
import fpgrowth.TransactionDatabase;
import rinterface.RInterface;

/**
 *
 * @author jfili
 */
public class JavaIDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap<String, String> conds = new HashMap<>();
        
        conds.put("sepallength", "-inf_to_5.55");
        
        ClassAssociationRule car = new ClassAssociationRule(conds, "Setosa");
        
        HashMap<String, String> conds2 = new HashMap<>();
        conds2.put("sepallength", "-inf_to_5.55");
        
        ClassAssociationRule car2 = new ClassAssociationRule(conds2, "Setosa");
        
        
       
        DataFrame df = new DataFrame();
        
        df.readFromCSV("C:/code/python/machine_learning/assoc_rules/train/iris0.csv");
        String[][] txns = df.getTransactions();
        
        
        
        
        /*
        for (int i = 0; i <= 135; i++) {
            System.out.println(df.getTransactions()[i][colIdx]);
            
        }
        */
        
        
        
        System.out.println("-----");
        
        TransactionDatabase tDB = df.convertToTransactionDatabase();
        
        //System.out.println(tDB);
        
        tDB.countFrequentItems();
        
        HashMap<FrequentItem, Integer> hashM = tDB.getFrequentItemsFrequenciesMap();
        
        System.out.println("------");
        for (FrequentItem freq : hashM.keySet()) {
            System.out.println(freq + " --> " + hashM.get(freq));
        }
      
        tDB.orderByFrequent();
        
        System.out.println(tDB);

        FPGrowth fpGrowth = new FPGrowth(tDB);
        fpGrowth.grow();
       
        System.out.println(fpGrowth.getTree());
        
        
        
    }

    
}
