package com.est.colection;

import java.util.ArrayList;

/**
 * @author estevam
 */
@SuppressWarnings("unchecked")
public class CloneCollection {

    private ArrayList<String> iClone;

	public ArrayList<String> clone(ArrayList<String> aList) {

		ArrayList<String> list = new ArrayList<String>(aList);
        iClone = (ArrayList<String>) list.clone();

        return iClone;
    }
}
