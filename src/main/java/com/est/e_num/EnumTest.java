/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.e_num;

/**
 *
 * @author estevam
 */
public class EnumTest {

   Company iName;
    
    public EnumTest() {
    }

    public enum Company {

        EBAY, PAYPAL, GOOGLE, YAHOO, ATT
    }

    public void setCompany(Company aName) {
        this.iName = aName;
    }

}
