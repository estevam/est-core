/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author estevam
 */
public class SortObj extends SortCollection<String> {
    
    public SortObj() {
        super();
        iComparator = new Comparator<String>() {
            //@Override
            public int compare(String o1, String o2) {
                int compResult = 0;
                if (iCurrentSortField.compareToIgnoreCase("compare_string") == 0) {
                    if (o1 != null && o2 != null) {
                        compResult = o1.compareToIgnoreCase(o2);
                    }
                } else if (iCurrentSortField.compareToIgnoreCase("compare_date") == 1) {
                    Date first = new Date();
                    // first = o1.getCreateTime();
                    Date second = new Date();
                    //second = o2.getCreateTime();
                    compResult = first.before(second) ? 1 : -1;                    
                }
                
                return (iCurrentSortOrder == SortCollection.SortOrder.ASC ? compResult : -compResult);
            }
        };
    }
}
