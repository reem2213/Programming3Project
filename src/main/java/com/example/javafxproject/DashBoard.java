package com.example.javafxproject;

import java.sql.*;

import javafx.application.Application;
import javafx.beans.binding.DoubleExpression;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashBoard extends Application{

   private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    private Label home_totalEmployees;
    private Label home_totalPresents;
    private Label home_totalInactiveEm;
    public DashBoard() throws SQLException {
        Stage s=new Stage();
        start(s);
    }

    public void start(Stage stage) throws SQLException {
        database c3=new database();
        BorderPane borderpane = new BorderPane();

        HBox h = new HBox(5);
        h.setPadding(new Insets(25, 5, 5, 5));
        ImageView imageview = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\userr.png");
        imageview.setFitHeight(30);
        imageview.setFitWidth(35);

        Label label = new Label("Employee Management System");
        label.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        label.setTextFill(Color.BLACK);
        h.getChildren().addAll(imageview, label);

        VBox v = new VBox(5);
        v.setPadding(new Insets(100, 75, 5, 35));

        ImageView i = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\image1.png");
        i.setFitHeight(150);
        i.setFitWidth(210);

        Label label1 = new Label("Welcome,");
        label1.setFont(Font.font("Serif", FontWeight.BOLD, null, 30));
        label1.setTextFill(Color.BLACK);

        Label label2 = new Label("Admin");
        label2.setFont(Font.font("Serif", FontWeight.BOLD, null, 30));
        label2.setTextFill(Color.BLACK);


        Line line = new Line();
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        line.setStartX(200);


        v.getChildren().addAll(i, label1, label2, line);




        ImageView i1 = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\home.png");
        i1.setFitHeight(25);
        i1.setFitWidth(25);

        ImageView i2 = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\add.png");
        i2.setFitHeight(25);
        i2.setFitWidth(25);

        ImageView i3 = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\salary.png");
        i3.setFitHeight(25);
        i3.setFitWidth(25);

        ImageView i4 = new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\logout.png");
        i4.setFitHeight(25);
        i4.setFitWidth(25);

        Button b1 = new Button("HOME   ", i1);
        //b1.setBorder(Color.WHITE);
        b1.setStyle("-fx-background-color: lightgreen");
        b1.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));

        Button b2 = new Button("ADD EMPLOYEE ", i2);
        b2.setStyle("-fx-background-color: lightgreen");
        b2.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));



        Button b3 = new Button("EMPLOYEE SALARY", i3);
        b3.setStyle("-fx-background-color: lightgreen");

        b3.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        b3.setLayoutY(200);
        b3.setLayoutX(5);

        Button b4 = new Button("LOGOUT", i4);

        b4.setStyle("-fx-background-color: lightgreen");
        b4.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        b4.setLayoutY(400);
        b4.setLayoutX(5);
        b4.setOnMousePressed(e1->{
            stage.hide();
            new login();
        });

        VBox v1=new VBox(10);
        v1.setMargin(b1,new Insets(0,0,0,30));
        b1.setMinWidth(150);
        b1.setOnMouseEntered(e1 ->b1.setId("hoverMenyStyle"));
        b1.setOnMouseExited(e1 ->b1.setId("menuStyle"));

        v1.setMargin(b2,new Insets(0,0,0,30));
        b2.setMinWidth(150);
        b2.setOnMouseEntered(e1 ->b2.setId("hoverMenyStyle"));
        b1.setOnMouseExited(e1 ->b1.setId("menuStyle"));

        v1.setMargin(b3,new Insets(0,0,0,30));
        b3.setMinWidth(150);
        b3.setOnMouseEntered(e1 ->b3.setId("hoverMenyStyle"));
        b3.setOnMouseExited(e1 ->b3.setId("menuStyle"));

        v1.setMargin(b4,new Insets(0,0,0,30));
        b4.setMinWidth(150);
        b4.setOnMouseEntered(e1 ->b3.setId("hoverMenyStyle"));
        b4.setOnMouseExited(e1 ->b3.setId("menuStyle"));
        // menuBox.setMargin(btnOrder,new Insets(0,0,0,30));


        b1.setOnMousePressed(e1->{
            stage.hide();
            //stage.show();
            try {
                new DashBoard();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        b2.setOnMousePressed(e1->{
            stage.hide();
            new empManagement();
        });

        b3.setOnMousePressed(e1->{
            stage.hide();
            new empSalary();
        });

        //v1.getChildren().addAll(b1,b2,b3);



        VBox Vbox=new VBox();
        Vbox.setStyle("-fx-background-color: lightgreen");
        v1.getChildren().addAll(b1,b2,b3,b4);
        Vbox.getChildren().addAll(h, v, v1);












        Pane pane=new Pane();
        pane.setPadding(new Insets(17, 50, 50, 50));

        Rectangle r=new Rectangle(270,220);
        r.setLayoutX(50);
        r.setLayoutY(20);
        r.setFill(null);
        r.setStroke(Color.LIGHTGREEN);
        r.setStrokeWidth(2);

        Rectangle r2=new Rectangle(270,220);
        r2.setLayoutX(390);
        r2.setLayoutY(20);
        r2.setFill(null);
        r2.setStroke(Color.LIGHTGREEN);
        r2.setStrokeWidth(2);

        Rectangle r3=new Rectangle(270,220);
        r3.setLayoutX(235);
        r3.setLayoutY(260);
        r3.setFill(null);
        r3.setStroke(Color.LIGHTGREEN);
        r3.setStrokeWidth(2);

        ImageView i5=new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\userr.png");
        i5.setFitHeight(100);
        i5.setFitWidth(100);
        i5.setLayoutX(400);
        i5.setLayoutY(50);

        Label l1=new Label("Total Employees");
        l1.setLayoutX(450);
        l1.setLayoutY(170);
        l1.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 20));
        l1.setTextFill(Color.BLACK);

        Label lcount=new Label("0");
        lcount.setLayoutX(620);
        lcount.setLayoutY(50);
        lcount.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 30));
        lcount.setTextFill(Color.BLACK);
        c3.homeTotalEmployees(lcount);


        ImageView i6=new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\users.png");
        i6.setFitHeight(100);
        i6.setFitWidth(100);
        i6.setLayoutX(60);
        i6.setLayoutY(50);

        Label l2=new Label("Total Presents");
        l2.setLayoutX(90);
        l2.setLayoutY(170);
        l2.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 20));
        l2.setTextFill(Color.BLACK);

        Label lcount2=new Label("0");
        lcount2.setLayoutX(280);
        lcount2.setLayoutY(50);
        lcount2.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 30));
        lcount2.setTextFill(Color.BLACK);
        c3.hometotalPresents(lcount2);

        ImageView i7=new ImageView("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\minus.png");
        i7.setFitHeight(100);
        i7.setFitWidth(100);
        i7.setLayoutX(260);
        i7.setLayoutY(280);

        Label l3=new Label("Total Inactive employee");
        l3.setLayoutX(280);
        l3.setLayoutY(410);
        l3.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 18));
        l3.setTextFill(Color.BLACK);

        Label lcount3=new Label("0");
        lcount3.setLayoutX(460);
        lcount3.setLayoutY(300);
        lcount3.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 30));
        lcount3.setTextFill(Color.BLACK);
        c3.hometotalInactiveEmploye(lcount3);


        AnchorPane anchorpane1=new AnchorPane();
        anchorpane1.setStyle("-fx-background-color: lightgreen");
        anchorpane1.setMaxHeight(100);
        anchorpane1.setMaxWidth(100);
        anchorpane1.setLayoutX(60);
        anchorpane1.setLayoutY(30);
        anchorpane1.setPadding(new Insets(150, 200, 50, 50));
        //anchorpane1.getChildren().add(l1);

        AnchorPane anchorpane2=new AnchorPane();
        anchorpane2.setStyle("-fx-background-color: lightgreen");
        anchorpane2.setMaxHeight(100);
        anchorpane2.setMaxWidth(100);
        anchorpane2.setLayoutX(400);
        anchorpane2.setLayoutY(30);
        anchorpane2.setPadding(new Insets(150, 200, 50, 50));
       // anchorpane2.getChildren().add(l1);



        AnchorPane anchorpane3=new AnchorPane();
        anchorpane3.setStyle("-fx-background-color: lightgreen");
        anchorpane3.setMaxHeight(100);
        anchorpane3.setMaxWidth(100);
        anchorpane3.setLayoutX(245);
        anchorpane3.setLayoutY(270);
        anchorpane3.setPadding(new Insets(150, 200, 50, 50));



        pane.getChildren().addAll(r,r2,r3,anchorpane1,anchorpane2,anchorpane3,l1,i5,lcount,l2,i6,lcount2,l3,i7,lcount3);



        borderpane.setLeft(Vbox);
        borderpane.setRight(pane);


        Scene scene2=new Scene(borderpane,1150,700);
        stage.setTitle("");
        stage.setScene(scene2);
        stage.show();

    }


   /* public static void main (String[] args) {
        launch (args);
    }*/
}
