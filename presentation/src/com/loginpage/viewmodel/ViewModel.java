package com.loginpage.viewmodel;


import IO.forpresentation.IPresentation;
import com.GenericRouter;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


import usecases.BusinessUseCaseImpl;

public class ViewModel<T> extends GenericRouter {
    IPresentation ip = new BusinessUseCaseImpl();

    @Override
    public void run() {
        Scene scene2 = new Scene(new GridPane(), 640, 380);
        setroute(scene2);

        getpresenter().loginResult(ip.execute());
    }

}

