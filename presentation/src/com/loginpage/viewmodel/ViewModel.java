package com.loginpage.viewmodel;


import IO.forpresentation.IPresentation;
import com.GenericRouter;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


import usecases.BusinessUseCaseImpl;

import java.util.concurrent.ExecutionException;

public class ViewModel<T> extends GenericRouter {
    IPresentation ip = new BusinessUseCaseImpl();

    @Override
    public void run() throws ExecutionException, InterruptedException {
        Scene scene2 = new Scene(new GridPane(), 640, 380);
        setroute(scene2);
        System.out.println(ip.execute().get());
        getpresenter().loginResult((T)ip.execute().get());
    }

}

