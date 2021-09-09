package com.loginpage.view;

import com.loginpage.viewmodel.ViewModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage<T extends Stage> implements ILoginPage<T> {
    ViewModel vm;
    private Stage _stage;

    public LoginPage(Stage s) {
        this._stage = s;
        setupUI();
        setupMVVM();
    }

    void setupUI() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button b = new Button("Authorize");
        TextField tf = new TextField();
        //tf.textProperty().bind(Bindings.convert(l.textProperty()));
        // l.textProperty().bind(Bindings.convert(tf.textProperty()));

        tf.setPromptText("email address");
        PasswordField pw = new PasswordField();
        pw.setPromptText("password");
        ImageView iv2 = new ImageView(new Image("http://icons.iconarchive.com/icons/kidaubis-design/cool-heroes/128/Starwars-Stormtrooper-icon.png"));
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setY(50);
        b.setMinWidth(300);
        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.setVgap(20);
        root.addRow(2, l);

        root.addRow(1, iv2);
        root.addRow(3, tf);
        root.addRow(4, pw);
        root.addRow(5, b);

        Scene scene = new Scene(root, 640, 380);

        //    b.onMouseClickedProperty().bind();

        b.setOnMouseClicked(mouseEvent -> {
            try {
                //new run();
                //Scene scene2 = new Scene(new GridPane(), 640, 380);
                //vm.setroute(scene2);
                vm.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        this._stage.setScene(scene);
        this._stage.setTitle("demo");
        this._stage.show();
    }

    void setupMVVM() {
        vm = new ViewModel();
        vm.setpresenter(this);
    }

    @Override
    public void loginResult(T args) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you! :\n\n\n\n" + args);
        alert.showAndWait();

    }

    @Override
    public Stage get() {
        return this._stage;
    }


}
