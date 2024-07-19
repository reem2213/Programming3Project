package com;

import com.example.javafxproject.employee;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDB
{


    public static Connection dbConn() {
        Connection conn=null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://REEM-PC\\SQLEXPRESS;" +
                    "databaseName=EmpM;integratedSecurity=true;" +
                    "encrypt=true;trustServerCertificate=true";
             conn  = DriverManager.getConnection(url);
            Statement stat=conn.createStatement();
            String query="Select * from table1";
            ResultSet rs=stat.executeQuery(query);

            while(rs.next()){
               // data.add(new employee(rs.getInt(1),rs.getString(2),
                       // ""+rs.getString(3),""+
                     //   rs.getString(4),""+rs.getString(5),
                      //  ""+rs.getString(6)));
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE,null,ex);

        }
        return conn;
    }
}
