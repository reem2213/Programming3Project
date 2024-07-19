package com.example.javafxproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {
    private Label home_totalEmployees;
    private Label home_totalPresents;
    private Label home_totalInactiveEm;
    static Connection conn;
    PreparedStatement prep=null;
    ResultSet rs=null;
    private TableView<employee> addEmployee_tableView;
    private TableColumn<employee, Integer> addEmployee_col_employeeId;
    private TableColumn<employee, String> addEmployee_col_firstname;
    private TableColumn<employee, String> addEmployee_col_lastname;
    private TableColumn<employee, String> addEmployee_col_gender;
    private TableColumn<employee, Integer> addEmployee_col_phoneNb;
    private TableColumn<employee, String> addEmployee_col_position;
    private ObservableList<employee> data;

    public database(){
        connectDb();
    }
    private TableView<employee> table1 = new TableView<employee>();
   // ObservableList<employee> data = FXCollections.observableArrayList();

    public static void connectDb() {
        String connectURL = "jdbc:sqlserver://REEM-PC\\SQLEXPRESS;" +
                "databaseName=EmpM;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(connectURL);
            System.out.println("connect()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployees(ObservableList<employee> list) throws SQLException{
        String sql="select EmployeeId,Firstname,Lastname,Gender,PhoneNb,Position from table1";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next()){
            list.add(new employee(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)));
            System.out.println(res.getString(1)+ " " +res.getString(2)+ " " +res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6));
        }
    }

    public static void AddEmployee(ObservableList<employee> list, String empid, String fname, String lname, ComboBox gender, String phnum, ComboBox pos) throws SQLException{
        String sql="Insert into table1 Values ('"+empid+"','"+fname+"','"+lname+"','"+
                gender.getSelectionModel().getSelectedItem()+"','"+phnum+"','"+pos.getSelectionModel().getSelectedItem()+"');";
        try {
            Alert alert;

            if (empid.isEmpty()
                    || fname.isEmpty()
                    || lname.isEmpty()
                    || phnum.isEmpty()
            ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Text Fields are empty!");
                alert.showAndWait();
            } else {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int num = stmt.executeUpdate();
                System.out.println("updated");
                list.clear();
                getEmployees(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void deleteEmp(ObservableList<employee> list,String EmpId) throws SQLException{
        String sql="Delete from table1 WHERE EmployeeId='"+ EmpId+"'";
        try {
            Alert alert;

            if (EmpId.isEmpty()
                    ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Text Fields are empty!");
                alert.showAndWait();
            } else {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int num = stmt.executeUpdate();
                System.out.println("deleteed");
                list.clear();
                getEmployees(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public static void clearr(ObservableList<employee> list) throws SQLException {
        String sql = "Delete from table1";

                PreparedStatement stmt = conn.prepareStatement(sql);
                int num = stmt.executeUpdate();
                System.out.println("deleteed");
                list.clear();



    }
        public static void updateEmp(ObservableList<employee> list,String empid, String fname, String lname, ComboBox gender, String phnum, ComboBox pos)throws SQLException{
        String sql="update table1 set EmployeeId='"+empid+"',Firstname='"+fname+"',Lastname='"+lname
                +"',Gender='"+gender.getSelectionModel().getSelectedItem()+"',PhoneNb='"+phnum
                +"',Position='"+pos.getSelectionModel().getSelectedItem()+"'WHERE EmployeeId='"+empid+"'";
        try {
            Alert alert;

            if (empid.isEmpty()
                    || fname.isEmpty()
                    || lname.isEmpty()
                    || phnum.isEmpty()
                    ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Text Fields are empty!");
                alert.showAndWait();
            } else {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int num = stmt.executeUpdate();
                System.out.println("updated");
                list.clear();
                getEmployees(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        public static boolean authenticate (String id, String password) throws SQLException {
            String sql = "Select email , password from users where email = ?  and password = ?";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,password from table3 where id =" + id + " and password = '" + password + "'");
            while (rs.next()) {
                return true;
            }
            return false;
        }

        public static void check () throws SQLException {
            String sql = "Select * from table3";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                System.out.println(res.getString(1) + " " + res.getString(2));
            }
        }

    public static void getEmployees2(ObservableList<employee> list2) throws SQLException{
        String sql2="select EmployeeId,Firstname,Lastname,Position,Salary from table2";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        ResultSet res = stmt.executeQuery();
        while (res.next()){
            list2.add(new employee(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
            System.out.println(res.getString(1)+ " " +res.getString(2)+ " " +res.getString(3)+" "+res.getString(4)+" "+res.getInt(5));
        }
    }

    public static void updateEmp2(ObservableList<employee> list2,String empid, String fname, String lname,  ComboBox tposs,String s)throws SQLException{
        String sql="update table2 set EmployeeId='"+empid+"',Firstname='"+fname+"',Lastname='"+lname
                +"',Position='"+tposs.getSelectionModel().getSelectedItem()+"',Salary='"+s+"'WHERE EmployeeId='"+empid+"'";
        try {
            Alert alert;

            if (empid.isEmpty()
                    || fname.isEmpty()
                    || lname.isEmpty()
                    || s.isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Text Fields are empty!");
                alert.showAndWait();
            } else {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int num = stmt.executeUpdate();
                System.out.println("updated");
                list2.clear();
                getEmployees2(list2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



/*

    static String score;
    static String name,passw;
    static empManagement a;
*/

    public void homeTotalEmployees(Label lcount) throws SQLException {

        String sql2="select COUNT(EmployeeId) FROM table1";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        ResultSet rs = stmt.executeQuery();

        int countData = 0;

        while (rs.next()) {
            countData = rs.getInt(1);
        }
        lcount.setText(String.valueOf(countData));
    }
    public void hometotalPresents(Label lcount) throws SQLException {

        String sql2="select COUNT(EmployeeId) FROM table2 where  Salary<>0";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        ResultSet rs = stmt.executeQuery();

        int countData = 0;

        while (rs.next()) {
            countData = rs.getInt(1);
        }
        lcount.setText(String.valueOf(countData));
    }
    //
    public void hometotalInactiveEmploye(Label lcount) throws SQLException {

        String sql2="select COUNT(EmployeeId) FROM table2 where  Salary=0";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        ResultSet rs = stmt.executeQuery();

        int countData = 0;

        while (rs.next()) {
            countData = rs.getInt(1);
        }
        lcount.setText(String.valueOf(countData));
    }


    public static void main(String[] args){
        new database();
    }


}