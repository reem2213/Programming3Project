package com.example.javafxproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import java.sql.SQLException;
public class Entry extends Application {


    public Entry() throws Exception {
        Stage s = new Stage();
        start(s);


    }

    @Override
    public void start(Stage stage) throws Exception {

        Label l = new Label("Progressinggg...");
        l.setFont(Font.font("Verdana", null, null, 10));
        l.setTextFill(Color.BLACK);
        l.setAlignment(Pos.TOP_CENTER);

        StackPane p = new StackPane();
        p.setStyle("-fx-background-color: lightgreen");

        ProgressBar pb = new ProgressBar();
        pb.setLayoutX(50);
        pb.setLayoutY(50);
        pb.setVisible(true);



        p.getChildren().addAll(l, pb);

        Scene s = new Scene(p, 200, 100);
        stage.setTitle("Progressing...");
        stage.setScene(s);
        stage.show();

        //new Thread((Runnable) s).start();

        //Thread.sleep(100);



    }
}


