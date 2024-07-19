package com.example.javafxproject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import java.sql.*;
import java.util.Optional;

import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.FontWeight;

import javafx.stage.Stage;


public class login extends Application {
    public login() {
        Stage s = new Stage();
        start(s);
    }

    private TextField password;
    private TextField username;
    database c = new database();

    public void start(Stage primaryStage) {


        BorderPane borderpane = new BorderPane();

        AnchorPane anchorpane1 = new AnchorPane();
        anchorpane1.prefHeight(400);
        anchorpane1.prefWidth(100);
        anchorpane1.setStyle("-fx-background-color: lightgreen");
        // AnchorPane.setLeftAnchor(label, 10.0);

        Image image = new Image("C:\\Users\\Reem\\IdeaProjects\\javafxProject\\src\\main\\java\\im\\image.png");
        ImageView im = new ImageView(image);
        im.setFitHeight(150);
        im.setFitWidth(250);

        Label l1 = new Label("Employee Management System");
        l1.setFont(Font.font("New Times Roman", FontWeight.BOLD, null, 20));
        l1.setTextFill(Color.WHITE);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(45, 25, 5, 5));

        vbox.getChildren().addAll(im, l1);
        anchorpane1.setLeftAnchor(vbox, 30.0);
        anchorpane1.getChildren().add(vbox);


        AnchorPane anchorpane2 = new AnchorPane();

        anchorpane2.prefHeight(400);
        anchorpane2.prefWidth(100);
        anchorpane2.setLayoutX(100);
        anchorpane2.setLayoutY(400);

        Label l2 = new Label("Welcome Back Admin!");
        l2.setFont(Font.font(" Times Roman", FontWeight.BOLD, null, 30));
        l2.setTextFill(Color.LIGHTGREEN);


        Label p = new Label();

        HBox h = new HBox(10);
        Label id = new Label("ID: ");
        id.setFont(Font.font("Serif", FontWeight.BOLD, null, 15));
        id.setTextFill(Color.GRAY);
        TextField t1 = new TextField();
        t1.prefHeight(50.0);
        t1.prefWidth(190.0);
        t1.focusedProperty().addListener((v, oldValue, newValue)
                    -> {
                if (!newValue) // if focus lost
                {
                    if (t1.getText().matches(".*[0-9].*")) {


                    } else {
                        id.setText("Please, input only numbers ");
                        id.setTextFill(Color.RED);

                    }
                }
            });


            h.getChildren().addAll(id, t1);

            Label pass = new Label("Password: ");
            pass.setFont(Font.font("Serif", FontWeight.BOLD, null, 15));
            pass.setTextFill(Color.GRAY);
            HBox h2 = new HBox(10);
            PasswordField t2 = new PasswordField();
            t2.setMaxHeight(50.0);
            t2.prefWidth(100);
            h2.getChildren().addAll(pass, t2);



            Button log = new Button("Login");
            log.setMaxHeight(70);
            log.setMaxWidth(240);
            log.setStyle("-fx-background-color: lightgreen");


            log.setOnMousePressed(e -> {
                try {
                    Alert alert;
                    if (c.authenticate(t1.getText(), t2.getText()) == true) {
                        //primaryStage.close();
                        primaryStage.hide();
                        new DashBoard();
                        System.out.println("Successfully!!");
                        c.check();
                    }
                    else{
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Incorrect Password!");
                        alert.showAndWait();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            });







            Button close = new Button("X");
            close.setStyle("-fx-background-color: lightgreen");
            close.setLayoutX(400);
            anchorpane2.getChildren().add(close);
            close.setOnMousePressed(e -> System.exit(0));

            VBox vbox2 = new VBox(20);
            vbox2.setPadding(new Insets(85, 25, 5, 5));
            vbox2.getChildren().addAll(l2, h, h2, log);
            anchorpane2.setRightAnchor(vbox2, 50.0);
            anchorpane2.getChildren().add(vbox2);

            //login.getScene().getWindow().hide();


            borderpane.setLeft(anchorpane1);
            borderpane.setRight(anchorpane2);

            Scene scene = new Scene(borderpane, 800, 350);
            primaryStage.setTitle("");
            primaryStage.setScene(scene);
            primaryStage.show();


        }


  /*  public static void main(String[] args){
        launch(args);
    }*/
}