/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.download_manager;




import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author estevam
 */
@SuppressWarnings("serial")
public class DownloadsTableModel extends AbstractTableModel implements Observer{

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void update(Observable o, Object arg) {
	   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.		
	}
    
}
