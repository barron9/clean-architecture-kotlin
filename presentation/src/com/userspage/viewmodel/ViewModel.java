package com.userspage.viewmodel;


import IO.forpresentation.IPresentation;
import com.GenericRouter;
import com.userspage.view.UsersPage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import usecases.BusinessUseCaseImpl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ViewModel<T> extends GenericRouter {
    IPresentation ip = new BusinessUseCaseImpl();

    @Override
    public void run() throws ExecutionException, InterruptedException {
        CompletableFuture D =  ip.getUsers();
        T F = (T)D.get();
        System.out.println(F);
        getpresenter().res(F);
    }

}

