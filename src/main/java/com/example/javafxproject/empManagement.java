package com.example.javafxproject;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class empManagement extends Application{
    public empManagement() {
        Stage s = new Stage();
        try {
            start(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    database dba;
    public static ArrayList<employee> employees= new ArrayList<employee> ();

    public static TableView<employee> table1 = new TableView<employee>();
    public static ObservableList<employee> data = FXCollections.observableArrayList();

    static Connection conn;
    PreparedStatement prep=null;
    ResultSet rs=null;




    public void start(Stage stage) throws SQLException {
        database c=new database();

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
     //   b2.setOnMouseEntered(e1 ->b2.setId("hoverMenyStyle"));
       // b1.setOnMouseExited(e1 ->b1.setId("menuStyle"));

        v1.setMargin(b3,new Insets(0,0,0,30));
        b3.setMinWidth(150);
       // b3.setOnMouseEntered(e1 ->b3.setId("hoverMenyStyle"));
      //  b3.setOnMouseExited(e1 ->b3.setId("menuStyle"));

        v1.setMargin(b4,new Insets(0,0,0,30));
        b4.setMinWidth(150);
      //  b4.setOnMouseEntered(e1 ->b3.setId("hoverMenyStyle"));
      //  b4.setOnMouseExited(e1 ->b3.setId("menuStyle"));
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


        AnchorPane pane = new AnchorPane();

        Rectangle r = new Rectangle(730, 250);
        r.setLayoutX(40);
        r.setLayoutY(440);
        r.setFill(Color.LIGHTGREEN);

        r.setStroke(Color.GRAY);
        r.setStrokeWidth(2);
        r.setArcWidth(40);
        r.setArcHeight(40);

        pane.getChildren().add(r);





        String list[] ={ "Female", "Male"};
        String list2[]={"Software Developer","App Developer","Marketer Coordinator","Web Developer"};



        GridPane grid=new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setLayoutX(70);
        grid.setLayoutY(480);

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

        Label gender = new Label("Gender : ");
        gender.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        gender.setTextFill(Color.BLACK);
        ComboBox tgender = new ComboBox(FXCollections.observableArrayList(list));
        tgender.setStyle("-fx-background-color: white");

        Label phonenb = new Label("Phone # : ");
        phonenb.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        phonenb.setTextFill(Color.BLACK);
        TextField tphonenb = new TextField();

        Label pos = new Label("Position : ");
        pos.setFont(Font.font("Verdana", FontWeight.BOLD, null, 15));
        phonenb.setTextFill(Color.BLACK);
        ComboBox tpos = new ComboBox(FXCollections.observableArrayList(list2));
        tpos.setStyle("-fx-background-color: white");

        Button clear = new Button("CLEAR");
          clear.setStyle("-fx-background-color: yellow");
        clear.setPrefSize(75, 50);
        clear.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        clear.setOnMousePressed(e1->{
            data.clear();
          /*  try {
                c.clearr(data);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/
        });


        Button remove = new Button("REMOVE");
           remove.setStyle("-fx-background-color: pink");
        remove.setPrefSize(100, 50);
        remove.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        //deleteBook

        remove.setOnMousePressed(e1->{
            try {
                c.deleteEmp(data,id.getText());
            } catch (SQLException e) {
                System.out.println("Errorr");
                throw new RuntimeException(e);
            }
        });

        Button update = new Button("UPDATE");
          update.setStyle("-fx-background-color: red");
        update.setPrefSize(100, 50);
        update.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        update.setOnMousePressed(e1->{
            try {
                c.updateEmp(data,id.getText(),tfname.getText(),tlname.getText(),tgender,tphonenb.getText(),tpos);
            } catch (SQLException e) {
                System.out.println("Errorr");
                throw new RuntimeException(e);
            }
        });

        Button add = new Button("ADD");
           add.setStyle("-fx-background-color: lightblue");
        add.setPrefSize(75, 50);
        add.setFont(Font.font("Times Roman", FontWeight.BOLD, null, 15));
        add.setOnMousePressed(e1->{
            try {

                c.AddEmployee(data,id.getText(),tfname.getText(),tlname.getText(),tgender,tphonenb.getText(),tpos);
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
        grid.add(gender,0,3);
        grid.add(tgender,1,3);
        grid.add(phonenb,2,0);
        grid.add(tphonenb,3,0);
        grid.add(pos,2,1);
        grid.add(tpos,3,1);
        grid.add(remove,2,2);
        grid.add(clear,3,2);
        grid.add(update,2,3);
        grid.add(add,3,3);



        Rectangle r2 = new Rectangle(740, 420);
        r2.setLayoutX(35);
        r2.setLayoutY(10);
        r2.setFill(Color.LIGHTGRAY);
        r2.setStroke(Color.GRAY);

        r2.setStrokeWidth(2);

        table1.setEditable(false);


        TableColumn<employee, Integer> emp_id=new TableColumn<>("employeeId");
        emp_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        emp_id.setMinWidth(100);

        TableColumn<employee,String> fn=new TableColumn<>("Firstname");
        fn.setCellValueFactory(new PropertyValueFactory<>("fname"));
        fn.setMinWidth(120);

        TableColumn<employee,String> ln=new TableColumn<>("Lastname");
        ln.setCellValueFactory(new PropertyValueFactory<>("lname"));
        ln.setMinWidth(120);

        TableColumn<employee,String> g=new TableColumn<>("Gender");
        g.setCellValueFactory(new PropertyValueFactory<>("gender"));
        g.setMinWidth(75);


        TableColumn<employee,String> phoneNb=new TableColumn<>("Phonenn");
        phoneNb.setCellValueFactory(new PropertyValueFactory<>("phoneNb"));
        phoneNb.setMinWidth(100);
       // phoneNb.setVisible(true);
      //  phoneNb.setResizable(false);



        TableColumn<employee,String> position=new TableColumn<>("Position");
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        position.setMinWidth(200);
        c.getEmployees(data) ;
        table1.setItems(data);
        table1.getColumns().addAll(emp_id, fn, ln, g, phoneNb, position);
        table1.setVisible(true);







        VBox vbox = new VBox();
        vbox.setSpacing(5);


        vbox.getChildren().add(table1);
        Pane panefortable = new Pane();//fiya l table w rectangle
        AnchorPane fortable = new AnchorPane();
        vbox.setPadding(new Insets(17, 600, 600, 45));
        fortable.getChildren().addAll(r2, vbox);
        panefortable.getChildren().add(fortable);
        borderpane.setLeft(Vbox);//everything in the left


        AnchorPane p = new AnchorPane();
        p.getChildren().addAll(pane,panefortable,grid);
        // borderpane.setBottom(grid);
        //   borderpane.getChildren().add(grid);


        borderpane.setRight(p);

        Scene scene2 = new Scene(borderpane, 1083, 700);
        stage.setTitle("");
        stage.setScene(scene2);

        stage.show();

    }
   /*
    public static void main(String[] args){
        launch(args);
    }*/
}
