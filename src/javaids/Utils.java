/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaids;

import java.util.Arrays;

/**
 *
 * @author jfili
 */
public class Utils {
    
    static <T> void printArray(T[] array) {
        Arrays.asList(array).forEach(System.out::println);
    }
    
}
