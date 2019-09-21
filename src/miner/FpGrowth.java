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
public class FpGrowth {
    
    
    public TransactionDatabase run(TransactionDatabase txnsDB) {
        txnsDB.countFrequentItems();
        txnsDB.orderByFrequent();
        
        return txnsDB;
    }
    
}
