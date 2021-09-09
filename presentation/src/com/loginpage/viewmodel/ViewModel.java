package com.loginpage.viewmodel;


import com.GenericRouter;
import com.loginpage.view.ILoginPage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewModel<T> extends GenericRouter<ILoginPage<Stage>> {

    public void run() {

        getpresenter().loginResult(null);
        Scene scene2 = new Scene(new GridPane(), 640, 380);
        setroute(scene2);

    }

}

