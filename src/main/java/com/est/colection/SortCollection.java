/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.List;
import java.util.Comparator;

/**
 *
 * @author estevam
 */
public class SortCollection<T> {

    public enum SortOrder {
        ASC, DESC
    }
    
    protected Comparator<T> iComparator;
    protected SortOrder iCurrentSortOrder;
    protected String iCurrentSortField;
    
    
    public void sordData(List<T> aList, SortOrder aCurrentSortOrder, String aCurrentSortField){
        iCurrentSortOrder = aCurrentSortOrder;
        iCurrentSortField = aCurrentSortField;
        java.util.Collections.sort(aList, iComparator);
        
    }
}
