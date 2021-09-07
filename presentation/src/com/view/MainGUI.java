package com.view;


import com.viewmodel.viewmodel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class MainGUI extends Application implements Ipresentation {

    viewmodel vm;
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button b = new Button("Authorize");
        TextField tf = new TextField();
        PasswordField pw = new PasswordField();
        ImageView iv2 = new ImageView(new Image("http://icons.iconarchive.com/icons/kidaubis-design/cool-heroes/128/Starwars-Stormtrooper-icon.png"));
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setY(50);
        b.setMinWidth(300);
        GridPane root=new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.setVgap(20);
        root.addRow(2,l);

        root.addRow(1,iv2);
        root.addRow(3,tf);
        root.addRow(4,pw);
        root.addRow(5,b);

        Scene scene = new Scene(root, 640, 380);

        b.setOnMouseClicked(mouseEvent -> {
            Scene scene2 = new Scene(new GridPane(), 640, 380);
            vm.setroute(scene2);
        });
        stage.setScene(scene);
        stage.setTitle("demo");
        stage.show();
        setupMVVM();
    }

    void setupMVVM(){
        vm = new viewmodel();
        vm.setpresenter(this);
    }

    @Override
    public void test() {

    }

    @Override
    public Stage getStage() {
        return this.stage;
    }
}
