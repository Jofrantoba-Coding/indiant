/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.indiant.server.shared.util;

/**
 *
 * @author jona
 */
public class FormatText {
    
    public static String firstCapitalLetter(String text){
        return text!=null?text.substring(0, 1).toUpperCase()+text.substring(1, text.length()).toLowerCase().trim():text;
    }
}
