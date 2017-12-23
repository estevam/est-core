/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.db;

import com.est.entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author estevam
 */
public class TestConnection {

    private List<User> iUserList;

    public static void main(String[] args) throws ConnectionDbException, SQLException {

        TestConnection test = new TestConnection();

       // test.updateUser();
       // test.addNewUser();
      // test.deleteUser(2);
        test.listUsers();
        
       
    }

    public void listUsers() throws SQLException {

        Connection iConn = null;
        Statement iStat = null;

        try {
            iConn = ConnectionDB.getConnection();
            iStat = (Statement) iConn.createStatement();
        }
        catch (ConnectionDbException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        iUserList = new ArrayList<User>();
        User iNewUser;
        try {

            ResultSet rs = iStat.executeQuery("select * from user");
            while (rs.next()) {

                iNewUser = new User();

                System.out.println("Id = " + rs.getString("id"));
                System.out.println("Title = " + rs.getString("name"));
                System.out.println("email = " + rs.getString("email"));
                System.out.println("login = " + rs.getString("login"));
                System.out.println("password = " + rs.getString("password"));

                iNewUser.setId(rs.getInt("id"));
                iNewUser.setName(rs.getString("name"));
                iNewUser.setEmail(rs.getString("email"));
                iNewUser.setLogin(rs.getString("login"));
                iNewUser.setPassword(rs.getString("password"));

                iUserList.add(iNewUser);
            }

            System.out.println("iUserList:" + iUserList.get(0).getName());

        }
        catch (Exception e) {
        }
        finally {
            iConn.close();
        }

    }

    public static void addNewUser() {
        Connection iConn = null;


        try {
            iConn = ConnectionDB.getConnection();

        }
        catch (ConnectionDbException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        User user = new User();
        user.setId(6);
        user.setName("ivo");
        user.setEmail("ivo@ivo.ca");
        user.setLogin("ivo");
        user.setPassword("ivo");

        try {
            String SQL = "insert into user (id,name,email,login,password) values (?,?,?,?,?)";
            PreparedStatement stmt = iConn.prepareStatement(SQL);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getLogin());
            stmt.setString(5, user.getPassword());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);


        }
    }
    
    
    public  void updateUser(Object aObj){
        
       Connection iConn = null;
       PreparedStatement stmt;
        try {
            iConn = ConnectionDB.getConnection();

        }
        catch (ConnectionDbException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        User user = new User();
        user.setId(5);
        user.setName("est");
        user.setEmail("est@est.com");
        user.setLogin("est");
        user.setPassword("est");
       
        try {
            String SQL = "update user set name=?, email=?, login=?, password=? where id=?";
            stmt = iConn.prepareStatement(SQL);
           
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getId());
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteUser(int aId) {

        Connection iConn = null;
        PreparedStatement stmt;
        User user = new User();
        user.setId(aId);
        try {
            iConn = ConnectionDB.getConnection();

        }
        catch (ConnectionDbException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt = iConn.prepareStatement("delete from user where id=?");
            stmt.setInt(1, user.getId());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);


        }

    }
}
