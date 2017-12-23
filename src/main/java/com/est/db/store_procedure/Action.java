/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.db.store_procedure;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estevam
 */
public class Action {

    // create table emp(name char(12),fathername char(12),password char(12));
    //    mysql> create procedure empproc(in name char(12),in fathername char(12),in password char(12))
    //        -> begin
    //        -> insert into emp values(name,fathername,password); 
    //        -> end;
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ConnectionDB mysql = new ConnectionDB();
        Connection conn = null;

        try {
            conn = mysql.getMySqlConnection();
        } catch (Exception ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, ex.toString());
        }
        Action action = new Action();

        for (int i = 0; i < 5; i++) {
            action.callStoreProcedure(conn);
        }
        conn.close();
        System.exit(0);
    }

    public void callStoreProcedure(Connection conn) throws SQLException {

        CallableStatement calstat = conn.prepareCall("{call empproc(?,?,?)}");
        calstat.setString(1, "Estevam");
        calstat.setString(2, "Amorim");
        calstat.setString(3, "Meneses");
        ResultSet rs = calstat.executeQuery();
        System.out.println(rs.toString());
        System.out.println("Your data has been inserted into table.");
    }
}
