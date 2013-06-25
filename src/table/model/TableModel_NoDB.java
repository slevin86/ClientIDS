/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author giovanni
 */
public class TableModel_NoDB extends AbstractTableModel {
        private String[] columnNames = {"ID", "First Name",
                                        "Last Name",
                                        "Sport",
                                        "# of Years",
                                        "Vegetarian"};
        private Object[][] data = {
	    {"1", "Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"2", "John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"3" ,"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"4", "Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"5", "Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        // ritorna l'id della scheda tecnica
        public Object getRowId(int row) {
            return data[row][0];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {

            data[row][col] = value;
            fireTableCellUpdated(row, col);


        }

       
    }

  

    
