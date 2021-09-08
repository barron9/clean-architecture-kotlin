package com;

import com.loginpage.view.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application   {

    @Override
    public void start(Stage stage) throws Exception {
        new LoginPage<>(stage);
    }
}
