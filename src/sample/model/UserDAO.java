/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import sample.util.DBUtil;

/**
 *
 * @author aruna
 */
public class UserDAO {
    public static boolean validate (String pass,String email) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM user WHERE password='"+pass+"' AND email='"+email+"'";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            User user = getUserFromResultSet(rsEmp);
 
            //Return employee object
            
            if(user == null){
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("While searching an user with " + email + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
        
    }
    
    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static User getUserFromResultSet(ResultSet rs) throws SQLException
    {
        User user = null;
        if (rs.next()) {
           user = new User();
           user.setEmail(rs.getString("email"));
    
        }
        return user;
    }
}
