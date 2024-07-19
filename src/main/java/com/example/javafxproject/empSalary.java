package com.example.javafxproject;
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

 */
import javafx.application.Application;
import javafx.beans.binding.DoubleExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class empSalary extends Application{
    static Stage s;
    public empSalary() {
        s = new Stage();
        try {
            start(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private AnchorPane home_form;
    private Label home_totalEmployees;
    private Label home_totalPresents;
    private Label home_totalInactiveEm;





    /*  private Connection connect;
      private Statement statement;
      private PreparedStatement prepare;
      private ResultSet result;*/

    public static TableView<employee> table2 = new TableView<employee>();
    public static ObservableList<employee> data2 = FXCollections.observableArrayList();

    public void start(Stage stage) throws SQLException {
        database c2=new database();
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


        String list2[]={"Software Developer","App Developer","Marketer Coordinator","Web Developer"};

        Pane pane1=new Pane();

        Rectangle r=new Rectangle(290,430);
        r.setLayoutX(22);
        r.setLayoutY(10);
        r.setFill(Color.LIGHTGREEN);
        r.setStroke(Color.GRAY);
        r.setStrokeWidth(2);
        r.setArcWidth(40);
        r.setArcHeight(40);
        pane1.getChildren().addAll(r);

        GridPane grid=new GridPane();
        grid.setHgap(5);
        grid.setVgap(15);
        grid.setLayoutX(30);
        grid.setLayoutY(50);

        Label employeeId = new Label("Employee ID: ");
        employeeId.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        employeeId.setTextFill(Color.BLACK);
        TextField id = new TextField();

        Label fname = new Label("First Name : ");
        fname.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        fname.setTextFill(Color.BLACK);
        TextField tfname = new TextField();

        Label lname = new Label("Last Name : ");
        lname.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        lname.setTextFill(Color.BLACK);
        TextField tlname = new TextField();

        Label pos=new Label("Position : ");
        pos.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 15));
        pos.setTextFill(Color.BLACK);
        ComboBox tposs = new ComboBox(FXCollections.observableArrayList(list2));
        tposs.setStyle("-fx-background-color: white");


        Label s=new Label("Salary($) : ");
        s.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 15));
        s.setTextFill(Color.BLACK);
        TextField ts=new TextField();

        Button clear=new Button("CLEAR");
        clear.setStyle("-fx-background-color: yellow");
        clear.setPrefSize(75, 50);
        clear.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 15));
        clear.setOnMousePressed(e1->{

            data2.clear();
        });

        Button update=new Button("UPDATE");
        update.setStyle("-fx-background-color: pink");
        update.setPrefSize(100, 50);
        update.setFont(Font.font("Times Roman", FontWeight.BOLD,null, 15));
        update.setOnMousePressed(e1->{
            try {
                c2.updateEmp2(data2,id.getText(),tfname.getText(),tlname.getText(),tposs,ts.getText());
            } catch (SQLException e) {
                System.out.println("Errorr");
                throw new RuntimeException(e);
            }
        });


        grid.add(employeeId,0,0);
        grid.add(id,1,0);
        grid.add(fname,0,1);
        grid.add(tfname,1,1);
        grid.add(lname,0,2);
        grid.add(tlname,1,2);
        grid.add(pos,0,3);
        grid.add(tposs,1,3);
        grid.add(s,0,4);
        grid.add(ts,1,4);
        grid.add(clear,0,5);
        grid.add(update,1,5);



        Rectangle r2=new Rectangle(535,410);
        r2.setLayoutX(320);
        r2.setLayoutY(30);
        r2.setFill(Color.GRAY);
        r2.setStroke(Color.GRAY);
        r2.setStrokeWidth(2);


        table2.setEditable(false);
        TableColumn<employee, Integer> emp_id=new TableColumn<>("employeeId");
        emp_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        emp_id.setMinWidth(100);

        TableColumn<employee,String> fn=new TableColumn<>("Firstname");
        fn.setCellValueFactory(new PropertyValueFactory<>("fname"));
        fn.setMinWidth(120);

        TableColumn<employee,String> ln=new TableColumn<>("Lastname");
        ln.setCellValueFactory(new PropertyValueFactory<>("lname"));
        ln.setMinWidth(120);

        TableColumn<employee,String> position=new TableColumn<>("Position");
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        position.setMinWidth(100);

        TableColumn<employee,Integer> sal=new TableColumn<>("Salary($)");
        sal.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sal.setMinWidth(85);


        c2.getEmployees2(data2); ;
        table2.setItems(data2);
        table2.getColumns().addAll(emp_id, fn, ln, position,sal);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().add(table2);
        Pane panefortable=new Pane();
        AnchorPane fortable=new AnchorPane();
        vbox.setPadding(new Insets(35,600,800,325));
        fortable.getChildren().addAll(r2,vbox);
        panefortable.getChildren().add(fortable);

        AnchorPane a=new AnchorPane();
        //a.setPadding(new Insets(350,500,5,500));
        a.getChildren().addAll(pane1,panefortable,grid);

        borderpane.setCenter(a);
        borderpane.setLeft(Vbox);



        Scene scene2=new Scene(borderpane,1170,700);
        stage.setTitle("");
        stage.setScene(scene2);
        stage.show();




    }


    /*public static void main (String[] args) {
        launch (args);
    }*/
}
