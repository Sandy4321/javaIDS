/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpgrowth;

import java.util.Optional;

/**
 *
 * @author jfili
 */
public class FPGrowth {
    
    private FPNode tree;
    private TransactionDatabase txnsDB;
    
    public FPGrowth(TransactionDatabase txnsDB) {
        tree = new FPNode();
        tree.setFreqItem(new FrequentItem("root", "-"));
        
        this.txnsDB = txnsDB; 
    }
    
    public void run(TransactionDatabase txnsDB) {
        
    }
    
    public void grow() {
        txnsDB.countFrequentItems();
        txnsDB.orderByFrequent();
        
        for (Transaction txn : txnsDB.getTransactions()) {
            FPNode currentTree = this.tree;

            for (FrequentItem freqItem : txn.getItems()) {
                Optional<FPNode> result = currentTree.getChild(freqItem);
                
                if (result.isPresent()) {
                    FPNode resultNode = result.get();
                    
                    resultNode.setFrequency(resultNode.getFrequency() + 1);
                    
                    currentTree = resultNode;
                } else {
                    FPNode newFPNode = new FPNode();
                    newFPNode.setFreqItem(freqItem);
                    newFPNode.setFrequency(1);
                    currentTree.getChildren().add(newFPNode);
                    
                    currentTree = newFPNode;
                }
            }
        }
        
    }

    /**
     * @return the tree
     */
    public FPNode getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(FPNode tree) {
        this.tree = tree;
    }

    /**
     * @return the txnsDB
     */
    public TransactionDatabase getTxnsDB() {
        return txnsDB;
    }

    /**
     * @param txnsDB the txnsDB to set
     */
    public void setTxnsDB(TransactionDatabase txnsDB) {
        this.txnsDB = txnsDB;
    }
    
    
    
}
