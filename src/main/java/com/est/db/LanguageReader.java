/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author estevam
 */
public class LanguageReader {

    public String getLanguage() throws ConnectionDbException, SQLException {

        String language = "";

        Connection conn = ConnectionDB.getConnection();
        Statement stat = (Statement) conn.createStatement();

        try {
            ResultSet rs = stat.executeQuery("SELECT SCValue FROM SysConf WHERE SysConfID =1");
            language = rs.getString("SCValue");

            if ("".equals(language)) {

                language = "en";
            }
        } catch (Exception e) {
        } finally {
            conn.close();
        }

        return language;
    }
}
