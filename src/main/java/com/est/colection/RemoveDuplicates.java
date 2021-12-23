/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author estevam
 */

public class RemoveDuplicates {

    public static List<Object> removeDuplicates(List<Object> aList) {
        int size = aList.size();
        int out = 0;
        {
            final Set<String> encountered = new HashSet<String>();
            for (int in = 0; in < size; in++) {
                final Object t = aList.get(in);
                // final String uid = aList.get(in).getUserUid();
                final boolean first = encountered.add("");
                if (first) {
                    aList.set(out++, t);
                }
            }
        }
        while (out < size) {
            aList.remove(--size);
        }
        return aList;
    }

    /**
     * Codigo limpo para entender
     *
     * @param iRecordList
     */
    @SuppressWarnings("unused")
	private void removeDuplicates(ArrayList<Record> iRecordList) {
        ArrayList<Record> iListSingleElements = new ArrayList<Record>();
        ArrayList<Record> iListPairsElements = new ArrayList<Record>();
        int size = iRecordList.size();

        Set<String> encountered = new HashSet<String>();   // Hashset nao permite elementos repetidos

        for (int in = 0; in < size; in++) {
            final String t = iRecordList.get(in).getTitle();
            final Record obj = iRecordList.get(in);
            final boolean first = encountered.add(t); // tenta adicionar 
            if (first) {
                iListSingleElements.add(obj); // se add n eh reptido
            } else {
                iListPairsElements.add(obj); // se add eh repetido 
            }
        }

    }

    class Record {

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
