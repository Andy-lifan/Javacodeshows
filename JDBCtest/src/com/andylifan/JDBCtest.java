package com.andylifan;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class JDBCtest {
 
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //access database
       Class.forName("com.mysql.cj.jdbc.Driver");
       String url = "jdbc:mysql://127.0.0.1:3306/dbtest1 ? serverTimezone=UTC";
       String user = "user1";
       String password = "123456";
       
        //build connection with database
        Connection conn = DriverManager.getConnection(url, user, password);
        
         String sql = "select * from employees";    
         Statement stmt = conn.createStatement();    // create one statement object
         ResultSet rs = stmt.executeQuery(sql);        //execute query
        
         int employeeid;
         String lastname, firstname;
         System.out.println("employeeid\tfirstname\tlastname\t");
        
        while(rs.next()) {        //query result collections
             employeeid = rs.getInt("employeeid");
             firstname = rs.getString("firstname");
             lastname = rs.getString("lastname");
            System.out.println(employeeid +"\t"+ "\t" + firstname +"\t"+ "\t" + lastname);
            }      
     }
  }
