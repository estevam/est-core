/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.colection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estevam
 */
public class SortMain {
     List<String> iList;

    public static void main(String[] args){
        SortMain sort = new SortMain();
        sort.loadList();
        
        
    }
    
    public  void loadList() {

        iList = new ArrayList<String>();
        iList.add("Toronto");
        iList.add("Ottawa");
        iList.add("London");
        iList.add("Montreal");
        iList.add("Calgary");
        iList.add("Vancouver");

    }
//    private void updateSortingState() {
//        CameraSort sort = new CameraSort();
//        sort.sortData(iListCameras, iSortOrder, iHeaderTitleIds[iSortIndex]);
//        iCenterTableView.update();
//
//    }
//
//    public void onHeaderClicked() {
//        int newSortFieldIndex = iCenterTableHeader.getSelectedIndex();
//        if (newSortFieldIndex == iSortIndex) {
//            iSortOrder = (iSortOrder == CameraMediaObjectSort.SortOrder.DESC
//                    ? CameraMediaObjectSort.SortOrder.ASC : CameraMediaObjectSort.SortOrder.DESC);
//        }
//        else {
//            iSortOrder = CameraMediaObjectSort.SortOrder.ASC;
//            iSortIndex = newSortFieldIndex;
//        }
//        updateSortingState();
//    }
}
